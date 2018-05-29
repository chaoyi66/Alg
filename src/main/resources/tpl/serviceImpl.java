package com.cc.xt.market.service.impl;

import com.cc.xt.market.common.VO.%su;
import com.cc.xt.market.common.base.BaseServiceImpl;
import com.cc.xt.market.common.base.PageUtils;
import com.cc.xt.market.common.base.XTMarketException;
import com.cc.xt.market.common.model.%suModel;
import com.cc.xt.market.common.param.%suPageParam;
import com.cc.xt.market.common.param.%suParam;
import com.cc.xt.market.dal.%as.%suDAO;
import com.cc.xt.market.dal.%as.%suDO;
import com.cc.xt.market.service.intf.%suService;
import com.google.common.collect.Lists;
import com.jiji.xmen.cable.commons.pagination.Page;
import com.jiji.xmen.cable.commons.utils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("%ssService")
public class %suServiceImpl extends BaseServiceImpl<%su, %suDO> implements %suService {

	@Autowired
	%suDAO %ssDAO;

	@Override
	public void deleteById(Long id) {
		%suDO %ss = new %suDO();
		%ss.setId(id);
		%ss.setDelFlag(1);
		dao.update(%ss);
	}

	@Override
	public List<%su> selectListByEO(%su %ss) {
		%suDO cond = convert2DO(%ss);
		cond.setDelFlag(0);
		List<%suDO> rs = dao.selectListByEO(cond);
		return convert2VOList(rs);
	}

	@Override
	public Map<Long, %su> getMapByIds(Collection<Long> ids) throws XTMarketException {
		Map<Long, %su> map = new HashMap<>();
		if (CollectionUtils.isEmpty(ids))
			return map;
		List<%suDO> list = dao.selectListByIdList(new ArrayList<>(ids), false);
		for (%suDO aa : list) {
			map.put(aa.getId(), convert2VO(aa));
		}
		return map;
	}

	@Override
	public Page<%suModel> queryPage(%suPageParam param) {
		// 需要用到此方法时解除注释，添加dao层
		// Page<%su> coursePage = %ssDAO.queryPage(param);
		Page<%su> coursePage = new Page<>();
		@SuppressWarnings("unchecked")
		Page<%suModel> page = PageUtils.copyPage(coursePage);
		List<%suModel> courseModel4iOSs = buildModelListByVOList(coursePage.getResult());
		page.setResult(courseModel4iOSs);
		return page;
	}

	@Override
	public %su convert2VO(%suDO entity) {
		return BeanUtils.convert(entity, %su.class);
	}

	@Override
	public %suDO convert2DO(%su entity) {
		return BeanUtils.convert(entity, %suDO.class);
	}

	private List<%su> convert2VOList(List<%suDO> %ssDOS) {
		List<%su> list = Lists.newArrayList();
		if (CollectionUtils.isEmpty(%ssDOS))
			return list;
		for (%suDO entityDO : %ssDOS) {
			list.add(convert2VO(entityDO));
		}
		return list;
	}

	private List<%suModel> buildModelListByVOList(List<%su> %sss) {
		List<%suModel> models = Lists.newArrayList();

		// //批量取资源模板
		// Set<Long> ids= Sets.newHashSet();
		// for (%su %ss : %sss) {
		// 	ids.add(%ss.getId());
		// }
		// Map<Long, %su> %ssMap = this.getMapByIds(ids);

		for (%su %ss : %sss) {
			%suModel model = new %suModel();
			models.add(model);
			model.set%su(%ss);
			// model.set%su(%ssMap.get(%ss.getId()));
		}
		return models;
	}
}
