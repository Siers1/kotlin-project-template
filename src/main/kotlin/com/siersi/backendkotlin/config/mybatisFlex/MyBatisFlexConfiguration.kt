package com.siersi.backendkotlin.config.mybatisFlex

import com.mybatisflex.core.audit.AuditManager
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration

@Configuration
class MyBatisFlexConfiguration() {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger("MybatisFlex-sql")
    }

    init {
        AuditManager.setAuditEnable(true)
        AuditManager.setMessageCollector { auditMessage ->
            logger.info("{}, 耗时{}ms", auditMessage.fullSql, auditMessage.elapsedTime)
        }
    }
}