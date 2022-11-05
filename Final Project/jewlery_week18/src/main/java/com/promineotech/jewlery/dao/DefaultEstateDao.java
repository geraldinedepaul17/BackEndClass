package com.promineotech.jewlery.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.promineotech.jewlery.entity.Jewlery;
import com.promineotech.jewlery.entity.Pieces;

import lombok.extern.slf4j.Slf4j;

@Service
@Component
@Slf4j

public class DefaultEstateDao implements EstateDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public List<Jewlery> fetchJewlery(Pieces piece, String design) {
		log.debug("DAO: piece={}, design={}", piece, design);

		// @formatter: off
		String sql = "" + "SELECT * " + "FROM pieces " + "WHERE piece_id =  "
				+ ":piece_id AND design_level = :design_level";
		// @formatter: on

		Map<String, Object> params = new HashMap<>();
		params.put("piece_id", piece.toString());
		params.put("design_level", design);

		return jdbcTemplate.query(sql, params, new RowMapper<>() {

			@Override
			public Jewlery mapRow(ResultSet rs, int rowNum) throws SQLException {
			//@formatter:off
				return Jewlery.builder()
						.basePrice(new BigDecimal(rs.getString("base_price")))
						. pieceId(Pieces.valueOf(rs.getString("piece_id")))
						. piecePK(rs.getLong("piece_pk"))
						.numpieces(rs.getInt("num_items"))
						.designLevel(rs.getString("design_level"))
						.itemSize(rs.getInt("item_size"))
						.build();
				//@formatter: on

			}
			});
	}
}
