package spring_annotations;

import org.springframework.stereotype.Component;

@Component
public class InformeFinanciero2 implements CreacionInformeFinanciero {

	@Override
	public String getInformeFinanciero() {
		// TODO Auto-generated method stub
		return "Presentaci�n del segundo informe financiero...";
	}
}