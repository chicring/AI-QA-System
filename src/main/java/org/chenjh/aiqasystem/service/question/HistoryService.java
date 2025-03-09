package org.chenjh.aiqasystem.service.question;

import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.dto.question.HeatmapDTO;
import org.chenjh.aiqasystem.domain.dto.question.QuestionHistoryDTO;
import org.chenjh.aiqasystem.domain.vo.question.QueryHistoryVO;

import java.util.List;

/**
 * @author hjong
 * @date 2025−03−07
 */
public interface HistoryService {

    /**
     * 查询历史记录
     * @param queryHistoryVO 查询条件
     * @param username 用户名
     * @return PageResult<QueryHistoryVO>
     */
    PageResult<QuestionHistoryDTO> queryHistory(QueryHistoryVO queryHistoryVO, String username);

    /**
     * 保存或更新历史记录
     * @param questionId 题目id
     * @param username 用户名
     */
    void saveOrUpdateHistory(Long questionId, String username);


    void updateHistory(Long questionId, String username, Integer status);

    /**
     * 删除历史记录
     * @param questionId 题目id
     * @param username 用户名
     */
    void deleteHistory(Long questionId, String username);

    List<HeatmapDTO> getHeatmapData(String username);
}
