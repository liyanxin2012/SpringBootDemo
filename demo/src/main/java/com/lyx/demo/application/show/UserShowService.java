package com.lyx.demo.application.show;

import com.lyx.demo.application.model.UserInfo;
import com.lyx.demo.domain.facade.CityFacade;
import com.lyx.demo.domain.model.PageResult;
import com.lyx.demo.domain.model.QueryResult;
import com.lyx.demo.domain.model.condition.QueryUserCondition;
import com.lyx.demo.domain.model.entity.UserEntity;
import com.lyx.demo.domain.model.valueobject.CityVO;
import com.lyx.demo.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.stream.Collectors;

/**
 * 用户信息展示服务
 *
 * @author Ryan
 */
@Service
public class UserShowService {

	/**
	 * 城市信息
	 */
	@Resource
	private CityFacade cityFacade;

	/**
	 * 用户资源库
	 */
	@Resource
	private UserRepository userRepository;


	/**
	 * 根据用户编号获取用户
	 *
	 * @param userId
	 * @return
	 */
	public UserInfo loadUser(String userId) {
		return convertUserEntity2UserInfo(userRepository.loadUser(userId));
	}

	/**
	 * 查询用户信息（模式1，推荐）
	 *
	 * @param condition
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public QueryResult<UserInfo> queryUserForResult(QueryUserCondition condition, int firstResult, int maxResults) {
		return convertUserEntity2UserInfo(userRepository.queryUserForResult(condition, firstResult, maxResults));
	}

	/**
	 * 查询用户信息（模式2）
	 *
	 * @param condition
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageResult<UserInfo> queryUserForResult2(QueryUserCondition condition, int pageNo, int pageSize) {
		return convertUserEntity2UserInfo(userRepository.queryUserForResult2(condition, pageNo, pageSize));
	}

	/**
	 * 转换用户查询结果
	 *
	 * @param userResult
	 * @return
	 */
	private PageResult<UserInfo> convertUserEntity2UserInfo(PageResult<UserEntity> userResult) {
		PageResult<UserInfo> userInfoResult = new PageResult<>();
		userInfoResult.setTotalPages(userResult.getTotalPages());
		userInfoResult.setTotalItems(userResult.getTotalItems());
		if (userResult.getElements() != null) {
			userInfoResult.setElements(userResult.getElements().stream().map(e -> convertUserEntity2UserInfo(e)).filter(e -> e != null).collect(Collectors.toList()));
		}

		return userInfoResult;
	}

	/**
	 * 转换用户查询结果
	 *
	 * @param userResult
	 * @return
	 */
	private QueryResult<UserInfo> convertUserEntity2UserInfo(QueryResult<UserEntity> userResult) {
		QueryResult<UserInfo> userInfoResult = new QueryResult<>();
		userInfoResult.setFirst(userResult.getFirst());
		userInfoResult.setCount(userResult.getCount());
		if (userResult.getElements() != null) {
			userInfoResult.setElements(userResult.getElements().stream().map(e -> convertUserEntity2UserInfo(e)).filter(e -> e != null).collect(Collectors.toList()));
		}

		return userInfoResult;
	}

	/**
	 * 转换用户信息
	 *
	 * @param userEntity
	 * @return
	 */
	private UserInfo convertUserEntity2UserInfo(UserEntity userEntity) {
		if (userEntity == null) {
			return null;
		}

		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(userEntity.getUserId());
		userInfo.setUserName(userEntity.getUserName());
		userInfo.setCityCode(userEntity.getCityCode());
		userInfo.setStatus(userEntity.getStatus());
		userInfo.setCreateTime(userEntity.getCreateTime());
		userInfo.setUpdateTime(userEntity.getUpdateTime());

		if (userInfo.getCityCode() != null) {
			CityVO cityVO = cityFacade.loadCityVO(userInfo.getCityCode());
			if (cityVO != null) {
				userInfo.setCityName(cityVO.getCityName());
			}
		}

		return userInfo;
	}
}
