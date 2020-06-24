package com.example.wechatwork;

import com.example.wechatwork.config.WechatWorkConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class WechatWorkSampleApplication implements CommandLineRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(WechatWorkSampleApplication.class);

	/*@Autowired
	private WechatWorkGateway gw;*/

	@Autowired
	private WechatWorkConfig wechatWorkConfig;

	public static void main(String[] args) { SpringApplication.run(WechatWorkSampleApplication.class, args); }

	@Profile("local")
	public void run(String... args) throws Exception {
		//GetTokenResponse res = gw.getAccessToken();
		//LOGGER.debug("Access Token: " + res.getAccess_token());
		LOGGER.debug("###### STARTED ######");
        LOGGER.debug("CorpId " + wechatWorkConfig.getCorpid());
	}
}
