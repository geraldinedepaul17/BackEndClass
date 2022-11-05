package com.promineotech.jewlery.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.promineotech.jewlery.Agent;
import com.promineotech.jewlery.entity.Color;
import com.promineotech.jewlery.entity.Customer;
import com.promineotech.jewlery.entity.Engine;
import com.promineotech.jewlery.entity.FuelType;
import com.promineotech.jewlery.entity.Jewlery;
import com.promineotech.jewlery.entity.JewleryModel;
import com.promineotech.jewlery.entity.Option;
import com.promineotech.jewlery.entity.OptionType;
import com.promineotech.jewlery.entity.Order;
import com.promineotech.jewlery.entity.Owner;
import com.promineotech.jewlery.entity.Pieces;
import com.promineotech.jewlery.entity.Stones;
import com.promineotech.jewlery.entity.Tire;

@Component
public class DefaultAgentDao implements AgentDao {
	  @Autowired
	  private NamedParameterJdbcTemplate jdbcTemplate;

	  @Override
	  public Jewlery saveJewlery(Owner owner, Jewlery jewlery, Stone stone,
	    BigDecimal price, List<Owner> options) {

	    SqlParams params = generateInsertSql(owner, jewlery, stone, price);

	    KeyHolder keyHolder = new GeneratedKeyHolder();
	    jdbcTemplate.update(params.sql, params.source, keyHolder);

	    Long jewleryPK = keyHolder.getKey().longValue();
	    saveOwner(owner, jewleryPK);

	    return Jewlery.builder()
	        .jewleryPK(jewleryPK)
	        .owner(owner)
	        .piece(jewlery)
	        .stone(stone)
	        .price(price)
	        .build();
	  }
	  //
	//  private void saveOptions(List<Option> options, Long orderPK) {
	 //   for(Option option : options) {
	  //    SqlParams params = generateInsertSql(option, orderPK);
	 //     jdbcTemplate.update(params.sql, params.source);
	//    }

	//  }
	  /**
	   *
	   * @param agent
	   * @param ownerPK
	   * @return
	   */
	  private SqlParams generateInsertSql( Agent owner, Long ownerPK) {
	    SqlParams params = new SqlParams();

	    // @formatter:off
	    params.sql = ""
	        + "INSERT INTO agent_owners ("
	        + "option_fk, jewlery_fk"
	        + ") VALUES ("
	        + ":owner_fk, :jewlery_fk"
	        + ")";
	    // @formatter:on

	    params.source.addValue("owner_fk", owner.getOwnerPK());
	    params.source.addValue("agent_fk", agentPK);

	    return params;
	  }

	  /**
	   *
	   * @param owner
	   * @param jewlery
	   * @param stone
	   * @param price
	   * @return
	   */
	  private SqlParams generateInsertSql(Owner owner, Jewlery jewlery, Stones stone,
	      Pieces piece, BigDecimal price) {
	    // @formatter:off
	    String sql = ""
	        + "INSERT INTO owners ("
	        + "owner_fk, stone_fk, piece_fk, jewlery_fk, price"
	        + ") VALUES ("
	        + ":owner_fk, :stone_fk,:piece_fk, :jewlery_fk, :price"
	        + ")";
	    // @formatter:on

	    SqlParams params = new SqlParams();

	    params.sql = sql;
	    params.source.addValue("owner_fk", owner.getOwnerPK());
	    params.source.addValue("stone_fk", stone.getStonePK());
	    params.source.addValue("piece_fk", piece.getPiecePK());
	    params.source.addValue("jewlery_fk", jewlery.getJewleryPK());
	    params.source.addValue("price", price);

	    return params;
	  }

	  /**
	   *
	   */
	  @Override
	  public List<Owner> fetchOwners(List<String> ownerIds) {
	    if (ownerIds.isEmpty()) {
	      return new LinkedList<>();
	    }

	    Map<String, Object> params = new HashMap<>();

	    // @formatter:off
	    String sql = ""
	        + "SELECT * "
	        + "FROM owner "
	        + "WHERE owner_id IN(";
	    // @formatter:on

	    for (int index = 0; index < ownerIds.size(); index++) {
	      String key = "owner_" + index;
	      sql += ":" + key + ", ";
	      params.put(key, ownerIds.get(index));
	    }

	    sql = sql.substring(0, sql.length() - 2);
	    sql += ")";

	    return jdbcTemplate.query(sql, params, new RowMapper<Owner>() {
	      @Override
	      public Owner mapRow(ResultSet rs, int rowNum) throws SQLException {
	        // @formatter:off
	        return Owner.builder()
	            .category(Owner.valueOf(rs.getString("owner")))
	            .design(rs.getString("design"))
	            .name(rs.getString("name"))
	            .ownerId(rs.getString("owner_id"))
	            .agentPK(rs.getLong("agent_pk"))
	            .price(rs.getBigDecimal("price"))
	            .build();
	        // @formatter:on
	      }
	    });
	  }

	  /**
	   *
	   */
	  @Override
	  public Optional,Owner> fetchOwner(String ownerId) {
	    // @formatter:off
	    String sql = ""
	        + "SELECT * "
	        + "FROM owners "
	        + "WHERE owner_id = :owner_id";
	    // @formatter:on

	    Map<String, Object> params = new HashMap<>();
	    params.put("owner_id", ownerId);

	    return Optional.ofNullable(
	        jdbcTemplate.query(sql, params, new OwnerResultSetExtractor()));
	  }

	  /**
	   *
	   */
	  @Override
	  public Optional<Jewlery> fetchPiece(JewleryPiece piece, String design, int pieces) {
	    // @formatter:off
	    String sql = ""
	        + "SELECT * "
	        + "FROM pieces "
	        + "WHERE piece_id = :piece_id "
	        + "AND design_level = :design_level "
	        + "AND num_pieces = :num_pieces";
	    // @formatter:on

	    Map<String, Object> params = new HashMap<>();
	    params.put("piece_id", piece.toString());
	    params.put("design_level", design);
	    params.put("num_pieces", pieces);

	    return Optional.ofNullable(
	        jdbcTemplate.query(sql, params, new PieceResultSetExtractor()));
	  }

	  /**
	   *
	   */
	  @Override
	  public Optional<Stones> fetchStones(String stoneId) {
	    // @formatter:off
	    String sql = ""
	        + "SELECT * "
	        + "FROM stones "
	        + "WHERE stone_id = :stone_id";
	    // @formatter:on

	    Map<String, Object> params = new HashMap<>();
	    params.put("stone_id", stoneId);

	    return Optional.ofNullable(
	        jdbcTemplate.query(sql, params, new StoneResultSetExtractor()));
	  }

	  /**
	   *
	   * @author Promineo
	   *
	   */
	  class TireResultSetExtractor implements ResultSetExtractor<Tire> {
	    @Override
	    public Tire extractData(ResultSet rs) throws SQLException {
	      rs.next();

	      // @formatter:off
	      return Tire.builder()
	          .manufacturer(rs.getString("manufacturer"))
	          .price(rs.getBigDecimal("price"))
	          .tireId(rs.getString("tire_id"))
	          .tirePK(rs.getLong("tire_pk"))
	          .tireSize(rs.getString("tire_size"))
	          .warrantyMiles(rs.getInt("warranty_miles"))
	          .build();
	      // @formatter:on
	    }

	  }

	  /**
	   *
	   * @author Promineo
	   *
	   */
	  class StoneResultSetExtractor implements ResultSetExtractor<Stones> {
	    @Override
	    public Stones extractData(ResultSet rs) throws SQLException {
	      rs.next();

	      // @formatter:off
	      return Stones.builder()
	          .stone(rs.getString("stone"))
	          .stoneId(rs.getString("stone_id"))
	          .stonePK(rs.getLong("stone_pk"))
	          .isMultistone(rs.getBoolean("is_multistone"))
	          .price(rs.getBigDecimal("price"))
	          .build();
	      // @formatter:on
	    }
	  }

	  /**
	   *
	   * @author Promineo
	   *
	   */
	  class PiecesResultSetExtractor implements ResultSetExtractor<Jewlery> {
	    @Override
	    public Jewlery extractData(ResultSet rs) throws SQLException {
	      rs.next();

	      // @formatter:off
	      return Jewlery.builder()
	          .basePrice(rs.getBigDecimal("base_price"))
	          .pieceId(Pieces.valueOf(rs.getString("piece_id")))
	          .piecePK(rs.getLong("piece_pk"))
	          .numPieces(rs.getInt("num_pieces"))
	          .designStyle(rs.getString("design_style"))
	          .itemSize(rs.getInt("item_size"))
	          .build();
	      // @formatter:on
	    }
	  }

	  /**
	   *
	   * @author Promineo
	   *
	   */
	  class OwnerResultSetExtractor implements ResultSetExtractor<Owner> {
	    @Override
	    public Owner extractData(ResultSet rs) throws SQLException {
	      rs.next();

	      // @formatter:off
	      return Owner.builder()
	          .ownerId(rs.getString("owner_id"))
	          .ownerPK(rs.getLong("owner_pk"))
	          .firstName(rs.getString("first_name"))
	          .lastName(rs.getString("last_name"))
	          .phone(rs.getString("phone"))
	          .build();
	      // @formatter:on

	    }
	  }

	  class SqlParams {
	    String sql;
	    MapSqlParameterSource source = new MapSqlParameterSource();
	  }

	@Override
	public List<Agent> fetchOwner(List<String> ownerIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Owner> fetchOwner(String ownerId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Jewlery> fetchPieces(String piece, int design) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Stones> fetchStone(String stoneId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Pieces> fetchPieces(String pieceId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Owner saveOwner(Owner owner, Jewlery jewlery, Stones stone, BigDecimal price, List<Agent> agents) {
		// TODO Auto-generated method stub
		return null;
	}
}