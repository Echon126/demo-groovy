import com.example.demo.entity.dto.TcSendDto
import com.example.demo.interfaces.ProcessControlService
import com.example.demo.interfaces.ProcessControlService

class RuntimeContext {

    static def startScheduling(TcSendDto dto) {
        def command = ProcessControlService.sendTcCommand(dto)
        if (command) {
            ProcessControlService.largeLoopCompare()
        }
    }

}
