package com.pb.implementation;

import com.pb.entity.CubeResult;
import com.pb.pitneyCube.PitneyCube;

public class CubeImplementation {
	PitneyCube cubeDLL = PitneyCube.INSTANCE;
	

	public CubeResult connectPrinter() {
		CubeResult pc = new CubeResult(false, 0, null);
		int res2 = cubeDLL.ConnectPrinterEx(2, new String(), 0, 0, 0, 0);
		try {
			if (res2 == 0)
				pc.setResult(true);
			else if (res2 == 71)
				pc.setError("No printers available to connect");
			else if (res2 == 72)
				pc.setError("Not supported printer");
			else if (res2 == 73)
				pc.setError("The printer is in an error status");
			else
				throw new IllegalArgumentException();
		} catch (IllegalArgumentException unknownCommand) {
			System.out.println("Unknown Command");
		}
		return pc;

	}

	public CubeResult setScaleZero() {
		boolean res = cubeDLL.SetScaleUnit();
		try {
			if (res == true)
				pc.setResult(res);
			else if (res == false)
				pc.setError("Set Scale Zero");
			else
				throw new IllegalArgumentException();

		} catch (IllegalArgumentException unknownCommand) {
			System.out.println("Unknown Command");
		}
		return pc;

	}

	public CubeResult checkStatus() {
	CubeResult	pc = new CubeResult(false, 0, null);
		int res = cubeDLL.CheckStatus();
		try {
			if (res == 0)
				pc.setResult(true);
			else if (res == 1)
				pc.setError("No Paper");
			else if (res == 2)
				pc.setError("Cover Open");
			else if (res == 3)
				pc.setError("Cutter jammed");
			else if (res == 4)
				pc.setError("TPH overheat");
			else if (res == 5)
				pc.setError("Auto-sensing failure Gap detection error");
			else if (res == 6)
				pc.setError("Ribbon end error");
			else if (res == 11)
				pc.setError("Board overheat");
			else if (res == 12)
				pc.setError("Motor overheat");
			else if (res == 13)
				pc.setError("Waiting for the label to be taken");
			else if (res == 30)
				pc.setError("Pause status");
			else if (res == 31)
				pc.setError("Roll near empty status");

			else
				throw new IllegalArgumentException();

		} catch (IllegalArgumentException unknownCommand) {
			System.out.println("Unknown Command");
		}
		return pc;

	}

	public CubeResult getScaleWeight() {
	Cube	pc = new CubeResult(false, 0, null);
		byte[] weight = new byte[48];
		int res = cubeDLL.GetScaleWeight(weight);
		pc.setResult(true);
		pc.setValue(res);
		return pc;
	}

	public CubeResult disconnectPrinter() {
		pc = new CubeResult(false, 0, null);
		boolean res = cubeDLL.DisconnectPrinter();
		if (res == true)
			pc.setResult(res);
		return pc;

	}

	public CubeResult getScaleVersion() {
		pc = new CubeResult(false, 0, null);
		byte[] version = new byte[48];
		int s = cubeDLL.GetScaleVersion(version);
		pc.setValue(s);
		pc.setResult(true);
		return pc;
	}

	public CubeResult getScaleGravityInformation() {
		pc = new CubeResult(false, 0, null);
		byte[] gravity = new byte[48];
		int gi = cubeDLL.GetScaleGravityInformation(gravity);
		pc.setValue(gi);
		return pc;
	}

	public CubeResult SetScaleUnit() {
		pc = new CubeResult(false, 0, null);
		boolean res = cubeDLL.SetScaleUnit();
		if (res == true)
			pc.setResult(res);
		else
			pc.setError("Set Scale Unit");
		return pc;
	}

	public CubeResult GetRollType() {
		pc = new CubeResult(false, 0, null);
		byte[] rollType = new byte[48];
		int res = cubeDLL.GetRollType(rollType);
		pc.setValue(res);
		return pc;
	}

	public CubeResult getPrintCount() {
		pc = new CubeResult(false, 0, null);
		int res = cubeDLL.GetPrintCount();
		pc.setValue(res);
		pc.setResult(true);
		return pc;

	}

	/*
	 * public String getPrinterList () { byte[] printerList = new byte[48];
	 * cubeDLL.GetRollType(printerList);
	 * 
	 * return s; }
	 * 
	 * public boolean setMediaRecognitionMode() { boolean result =
	 * cubeDLL.SetMediaRecognitionMode(0); return result; } /*public int
	 * GetScaleStatus () { int res= }
	 */
	/*
	 * public CubeResult GetPrinterInformation () { byte[] printerList = new
	 * byte[48]; cubeDLL.GetPrinterInformation(2,printerList); return ; }
	 */
	public CubeResult getProductNumber(CubeResult pc) {
		pc = new CubeResult(false, 0, null);
		byte[] productNumber = new byte[48];
		int res = cubeDLL.GetPB_ProductNumber(productNumber);
		pc.setValue(res);
		return pc;
	}

	public CubeResult getSerialNumber(CubeResult pc) {
		pc = new CubeResult(false, 0, null);
		byte[] serialNumber = new byte[48];
		int res = cubeDLL.GetPB_SerialNumber(serialNumber);
		pc.setValue(res);
		return pc;
	}

	public CubeResult RebootPrinter(CubeResult pc) {
		pc = new CubeResult(false, 0, null);
		boolean res = cubeDLL.RebootPrinter();
		try {
			if (res == true)
				pc.setResult(true);
			else if (res == false)
				pc.setError("Reboot Printer");
			else
				throw new IllegalArgumentException();

		} catch (IllegalArgumentException unknownCommand) {
			System.out.println("Unknown Command");
		}
		return pc;

	}
}