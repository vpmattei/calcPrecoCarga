package servlet;

public class Rota {

	private double valorTotal = 0;
	private double distPavRota;
	private double distSemPavRota;
	
	public void setDistPav(double distPav) {
		distPavRota = distPav;
		valorTotal = valorTotal + distPav*0.54;
	}

	public void setDistSemPav(double distSemPav) {
		distSemPavRota = distSemPav;
		valorTotal = valorTotal + distSemPav*0.62;
	}

	public void setToneladas(double ton) {
		if(ton > 5){
			ton = ton - 5;
			valorTotal = valorTotal + ton*0.02*(distSemPavRota+distPavRota);
		}
	}

	public void setVeiculo(boolean camBau, boolean camCac, boolean carreta) {
		if(camBau) {
	        valorTotal = valorTotal*1;
	    }
	    else if(camCac) {
	        valorTotal = valorTotal*1.05;
	    }
	    else if(carreta) {
	        valorTotal = valorTotal*1.12;
	    }
	}
	
	public double getValorTotal() {
		return valorTotal;
	}
}
