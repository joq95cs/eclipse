package spring_annotations;

import org.springframework.stereotype.Component;

@Component
public class InformeFinanciero1 implements CreacionInformeFinanciero {

	@Override
	public String getInformeFinanciero() {
		// TODO Auto-generated method stub
		return "Presentaci�n de primer informe financiero...";
	}
}