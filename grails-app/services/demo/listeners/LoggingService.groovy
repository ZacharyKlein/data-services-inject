package demo.listeners

import demo.Book
import demo.data.AuditService
import grails.events.annotation.gorm.Listener
import grails.gorm.transactions.Transactional
import org.grails.datastore.mapping.engine.event.PostInsertEvent
import org.grails.datastore.mapping.engine.event.PostUpdateEvent
import org.grails.datastore.mapping.engine.event.PreDeleteEvent

@Transactional
class LoggingService {

    AuditService auditService

    @Listener
    void afterSave(PostInsertEvent event) {
        if (event.entityObject instanceof Book) {
            log.info "After book save..."
            auditService.saveAudit("Book saved", ((Book) event.entityObject).id)
        }
    }

    @Listener
    void afterUpdate(PostUpdateEvent event) {
        if (event.entityObject instanceof Book) {
            log.info "After book update..."
            auditService.saveAudit("Book updated", ((Book) event.entityObject).id)
        }
    }

    @Listener
    void beforeDelete(PreDeleteEvent event) {
        if (event.entityObject instanceof Book) {
            log.info "Before book delete..."
            auditService.saveAudit("Book deleted", ((Book) event.entityObject).id)
        }
    }
}
