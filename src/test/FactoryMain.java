package test;

class Factory {
	private static Factory instance = null;
	private String factoryName;	
	private Factory() {};
	
	public static Factory getInstance() {
		if(instance == null) {
			instance = new Factory();
		}
		return instance;
	}
}
