package org.chenjh.aiqasystem.listener;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.chenjh.aiqasystem.listener.events.ViewQuestionEvent;
import org.chenjh.aiqasystem.repo.question.HistoryRepository;
import org.chenjh.aiqasystem.repo.question.QuestionRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author hjong
 * @date 2025−03−08
 */
@Slf4j
@Component
public class QuestionEventListener {

    @Resource
    private QuestionRepository questionRepository;

    @Resource
    private HistoryRepository historyRepository;

    /**
     * 保存题目浏览历史
     */
    @EventListener(value = ViewQuestionEvent.class)
    public void saveQuestionViewHistory(ViewQuestionEvent event) {
        log.info("保存用户:{} 浏览历史", event.getUsername());
        historyRepository.saveOrUpdateView(event.getQuestion().getQuestionId(), event.getUsername());
    }

    /**
     * 增加题目浏览数
     */
    @EventListener(value = ViewQuestionEvent.class)
    public void IncreaseQuestionViews(ViewQuestionEvent event) {
        log.info("增加题目:{} 浏览数", event.getQuestion().getQuestionId());
        questionRepository.updateViewCount(event.getQuestion().getQuestionId());
    }

}
