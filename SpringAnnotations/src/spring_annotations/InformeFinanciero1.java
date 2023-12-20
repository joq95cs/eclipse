package spring_annotations;

import org.springframework.stereotype.Component;

@Component
public class InformeFinanciero1 implements CreacionInformeFinanciero {

	@Override
	public String getInformeFinanciero() {
		// TODO Auto-generated method stub
		return "Presentación de primer informe financiero...";
	}
}