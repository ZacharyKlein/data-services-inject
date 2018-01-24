package demo.data

import demo.Audit
import grails.gorm.services.Service

@Service(Audit)
interface AuditService {

    Audit saveAudit(String event, Long bookId)
}
