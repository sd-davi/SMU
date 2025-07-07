package ufma.br.sistema_monitoria_ufma.model.Dto;

import javax.management.monitor.Monitor;

public class MonitorResumoDTO {
    private Monitor monitor;
    private Long totalMonitorias;

    public MonitorResumoDTO(Monitor monitor, Long totalMonitorias) {
        this.monitor = monitor;
        this.totalMonitorias = totalMonitorias;
    }

    public Monitor getMonitor() { return monitor; }
    public Long getTotalMonitorias() { return totalMonitorias; }
}
