package test;

class Factory {
	private String factoryName;
	
	private Factory() {};
	
	private static Factory instance = null;
	
	public static Factory getInstance() {
		if(instance == null) {
			instance = new Factory();
		}
		return instance;
	}
}
