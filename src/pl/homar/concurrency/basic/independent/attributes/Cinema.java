package pl.homar.concurrency.basic.independent.attributes;

public class Cinema {
	private long vacanciesCinema1;
	private long vacanciesCinema2;
	private final Object controlCinema1, controlCinema2;
	
	public Cinema(){
		controlCinema1 = new Object();
		controlCinema2 = new Object();
		setVacanciesCinema1(20);
		setVacanciesCinema2(20);
	}
	
	public boolean sellTickets1(int number){
		synchronized (controlCinema1) {
			if(number < getVacanciesCinema1()){
				setVacanciesCinema1(getVacanciesCinema1() - number);
				return true;
			}else{
				return false;
			}
		}
	}
	
	public boolean sellTickets2(int number){
		synchronized (controlCinema2) {
			if(number < getVacanciesCinema2()){
				setVacanciesCinema2(getVacanciesCinema2() - number);
				return true;
			}else{
				return false;
			}
		}
	}
	
	public boolean returnTickets1(int number){
		synchronized (controlCinema1) {
			setVacanciesCinema1(getVacanciesCinema1() + number);
			return true;
		}
	}
	
	public boolean returnTickets2(int number){
		synchronized (controlCinema2) {
			setVacanciesCinema2(getVacanciesCinema2() + number);
			return true;
		}
	}

	public long getVacanciesCinema1() {
		return vacanciesCinema1;
	}

	public void setVacanciesCinema1(long vacanciesCinema1) {
		this.vacanciesCinema1 = vacanciesCinema1;
	}

	public long getVacanciesCinema2() {
		return vacanciesCinema2;
	}

	public void setVacanciesCinema2(long vacanciesCinema2) {
		this.vacanciesCinema2 = vacanciesCinema2;
	}
	
	
}
