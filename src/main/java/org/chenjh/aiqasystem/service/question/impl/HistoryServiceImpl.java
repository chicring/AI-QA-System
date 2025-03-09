package org.chenjh.aiqasystem.service.question.impl;

import jakarta.annotation.Resource;
import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.dto.question.HeatmapDTO;
import org.chenjh.aiqasystem.domain.dto.question.QuestionHistoryDTO;
import org.chenjh.aiqasystem.domain.vo.question.QueryHistoryVO;
import org.chenjh.aiqasystem.repo.question.HistoryRepository;
import org.chenjh.aiqasystem.service.question.HistoryService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author hjong
 * @date 2025−03−07
 */

@Service
public class HistoryServiceImpl implements HistoryService {

    @Resource
    private HistoryRepository historyRepository;

    @Override
    public PageResult<QuestionHistoryDTO> queryHistory(QueryHistoryVO queryHistoryVO, String username) {
        return historyRepository.getQuestionHistoryList(queryHistoryVO, username);
    }

    @Override
    public void saveOrUpdateHistory(Long questionId, String username) {
        historyRepository.saveOrUpdateView(questionId, username);
    }

    @Override
    public void updateHistory(Long questionId, String username, Integer status) {
        historyRepository.update(questionId, username, status);
    }

    @Override
    public void deleteHistory(Long questionId, String username) {
        historyRepository.delete(questionId, username);
    }

    @Override
    public List<HeatmapDTO> getHeatmapData(String username) {
        List<HeatmapDTO> heatmapData = historyRepository.queryHeatmap(username);
//        Map<Instant, HeatmapDTO> dataMap = heatmapData.stream()
//                .collect(Collectors.toMap(
//                        HeatmapDTO::getDate,
//                        dto -> dto
//                ));
//
//        LocalDate startDate = LocalDate.now().withDayOfYear(1);  // 今年第一天
//        LocalDate endDate = startDate.withDayOfYear(startDate.lengthOfYear());  // 今年最后一天
//
//        List<HeatmapDTO> completeData = new ArrayList<>();
//        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
//            Instant instant = date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
//            HeatmapDTO dto = dataMap.getOrDefault(instant, new HeatmapDTO(
//                    instant,
//                    0
//            ));
//            completeData.add(dto);
//        }

        return heatmapData;
    }
}
