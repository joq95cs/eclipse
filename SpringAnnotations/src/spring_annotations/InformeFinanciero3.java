package spring_annotations;

import org.springframework.stereotype.Component;

@Component
public class InformeFinanciero3 implements CreacionInformeFinanciero {

	@Override
	public String getInformeFinanciero() {
		// TODO Auto-generated method stub
		return "Presentaci�n del tercer informe financiero...";
	}
}