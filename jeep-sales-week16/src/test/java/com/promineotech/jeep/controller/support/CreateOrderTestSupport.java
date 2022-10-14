package com.promineotech.jeep.controller.support;

public class CreateOrderTestSupport extends BaseTest {
/**
 * 
 * @return
 */
protected String createOrderBody() {
	  //formatter:off
    return "{\n"
        + "  \"customer\":\"STERN_TORO\",\n"
        + "  \"model\":\"COMPASS\",\n"
        + "  \"trim\":\"TRAILHAWK\",\n"
        + "  \"doors\":4,\n"
        + "  \"color\":\"OLIVE_GREEN\",\n"
        + "  \"engine\":\"3_0_DIESEL\",\n"
        + "  \"tire\":\"35_TOYO\",\n"
        + "  \"options\":[\n"
        + "    \"DOOR_QUAD_4\",\n"
        + "    \"EXT_QUAD_ALUM_FRONT\",\n"
        + "    \"EXT_WARN_WINCH\",\n"
        + "    \"EXT_WARN_BUMPER_FRONT\",\n"
        + "    \"EXT_WARN_BUMPER_REAR\",\n"
        + "    \"EXT_ARB_COMPRESSOR\"\n"
        + "  ]\n"
        + "";
         
        //formatter:on
  }
}