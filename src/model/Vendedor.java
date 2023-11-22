package model;

import java.sql.Date;

public final class Vendedor extends Pessoa{
	
	private Date data_entrada;
	private boolean habilitado;
	
	public Date getData_entrada() {
		return data_entrada;
	}
	public void setData_entrada(Date data_entrada) {
		this.data_entrada = data_entrada;
	}
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	

}
