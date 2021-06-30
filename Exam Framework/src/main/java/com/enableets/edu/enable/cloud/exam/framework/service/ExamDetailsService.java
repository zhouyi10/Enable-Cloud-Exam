package com.enableets.edu.enable.cloud.exam.framework.service;

import com.enableets.edu.enable.cloud.exam.framework.bo.ExamDetailsInfoBO;
import com.enableets.edu.enable.cloud.exam.framework.bo.ExamResultInfoBO;
import com.enableets.edu.enable.cloud.exam.framework.bo.ExamStatisticsInfoV2BO;
import com.enableets.edu.enable.cloud.exam.framework.core.ErrorConstants;
import com.enableets.edu.enable.cloud.exam.framework.dao.ExamDetailsInfoDAO;
import com.enableets.edu.enable.cloud.exam.framework.dao.ExamDetailsStepTaskInfoDAO;
import com.enableets.edu.enable.cloud.exam.framework.po.ExamDetailsInfoPO;
import com.enableets.edu.enable.cloud.exam.framework.po.ExamDetailsStepTaskInfoPO;
import com.enableets.edu.enable.cloud.exam.framework.po.ExamStatisticsInfoPO;
import com.enableets.edu.framework.core.service.ServiceAdapter;
import com.enableets.edu.framework.core.util.BeanUtils;
import com.enableets.edu.module.service.core.MicroServiceException;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

@Service
public class ExamDetailsService extends ServiceAdapter<ExamDetailsInfoBO, ExamDetailsInfoPO> {

	/** exam info service */
	@Autowired
	private ExamInfoService examInfoService;

	@Autowired
	private ExamDetailsInfoDAO examDetailsDAO;

	@Autowired
	private ExamDetailsStepTaskInfoDAO examDetailsStepTaskInfoDAO;

	@Autowired
	private ExamResultInfoService examResultInfoService;

	public List<ExamStatisticsInfoV2BO> queryExamDetailsInfoV2(Map<String, Object> condition) {
		List<ExamStatisticsInfoPO> examStatisticsList = examDetailsDAO.queryExamDetailsInfoV2(condition);
		return BeanUtils.convert(examStatisticsList, ExamStatisticsInfoV2BO.class);
	}

	public Integer countExamDetailsInfoV2(Map<String, Object> condition) {
		return examDetailsDAO.countV2(condition);
	}

	/**
	 * 根据考试详情id查询考试详情和考试结果
	 *
	 * @param examDetailsId
	 * @return
	 */
	public ExamDetailsInfoBO getExamDetailsByExamDetailsId(Long examDetailsId) {
		Map<String, Object> map = new HashMap<>();
		map.put("examDetailsId", examDetailsId);
		List<ExamDetailsInfoPO> examDetails = examDetailsDAO.queryExamDetails(map);
		ExamDetailsInfoBO examDetailsBO = null;
		if (!CollectionUtils.isEmpty(examDetails)) {
			examDetailsBO = BeanUtils.convert(examDetails.get(0), ExamDetailsInfoBO.class);
			List<ExamResultInfoBO> examResultInfoList = examResultInfoService.getExamResultInfo(examDetailsId);
			if (CollectionUtils.isEmpty(examResultInfoList)) {
				examDetailsBO.setExamResultInfoList(null);
			} else {
				examDetailsBO.setExamResultInfoList(examResultInfoList);
			}
		}
		return examDetailsBO;
	}

	/**
	 * bind activity to exam detail
	 * @param examDetailsIds exam details
	 * @param activityId activity id
	 */
	public boolean bindStepTask(String examDetailsIds, String activityId) {
		Assert.hasText(examDetailsIds, "exam details cannot be empty!");
		Assert.hasText(activityId, "activity id cannot be empty!");

		List<String> detailsIdList = Arrays.asList(examDetailsIds.split(","));
		// 1. check exam info
		Map<String, Object> map = new HashMap<>();
		map.put("examDetailsId", detailsIdList.get(0));
		List<ExamDetailsInfoPO> examDetails = examDetailsDAO.queryExamDetails(map);
		if (CollectionUtils.isEmpty(examDetails) || examDetails.get(0) == null) {
			throw new MicroServiceException(ErrorConstants.ERROR_CODE_EXAM_NOT_EXISTS, ErrorConstants.ERROR_MESSAGE_EXAM_NOT_EXISTS);
		}
		Long examId = examDetails.get(0).getExamId();
		// 2. update details activity id
		Example example = new Example(ExamDetailsStepTaskInfoPO.class);
		example.createCriteria().andIn("examDetailsId", detailsIdList);
		ExamDetailsStepTaskInfoPO po = new ExamDetailsStepTaskInfoPO();
		po.setActivityId(activityId);
		po.setUpdateTime(Calendar.getInstance().getTime());
		boolean result = examDetailsStepTaskInfoDAO.updateByExampleSelective(po, example) > 0;
		// 3. update exam publish status
		examInfoService.updatePublishStatus(examId);
		return result;
	}

}
