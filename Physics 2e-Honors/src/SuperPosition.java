import java.util.Scanner;
import java.util.*;

public class SuperPosition 
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		//base values for the circuit
		int r1 = 0, r2 = 0, r3 = 0, v1 = 0, v2 = 0;
		//iTot stands for total current
		double iTot = 0, iTotR1 = 0, iTotR2 = 0, iTotR3 = 0;
		double vTotR1 = 0, vTotR2 = 0, vTotR3 = 0;
		//next set will be the current in V1
		double vV1R1 = 0, vV1R2 = 0, vV1R3 = 0;
		double iV1 = 0, iV1R1 = 0, iV1R2 = 0, iV1R3 = 0;
		//next set will be the current in V2
		double vV2R1 = 0, vV2R2 = 0, vV2R3 = 0;
		double iV2 = 0, iV2R1 = 0, iV2R2 = 0, iV2R3 = 0;
		
		System.out.println(" |------R1------|------R2------|");
		System.out.println("---             |             ---");
		System.out.println(" -  V1          R3          V2 -");
		System.out.println(" |              |              |");
		System.out.println(" |--------------|--------------|");
		
		System.out.println("Imput R1: ");
		r1 = s.nextInt();
		System.out.println("Imput R2: ");
		r2 = s.nextInt();
		System.out.println("Imput R3: ");
		r3 = s.nextInt();
		System.out.println("Imput V1: ");
		v1 = s.nextInt();
		System.out.println("Imput V2: ");
		v2 = s.nextInt();
		
		//solve for equivalent resistance in each case
		double reqR1R3 = (1/((1/r1)+(1/r3)));
		double reqR2R3 = (1/((1/r2)+(1/r3)));
		
		/**
		 * Solve for current and voltage in V1
		 */
		iV1 = (v1/(reqR2R3 + r1));
		
		//solve for voltage in each resistor
		vV1R1 = (r1*iV1);
		vV1R2 = (v1 - vV1R1);
		vV1R3 =  vV1R2;
		
		//solve for current in each resistor
		iV1R1 = (vV1R1/r1);
		iV1R2 = (vV1R2/r2);
		iV1R3 = (vV1R3/r3);
		
		/**
		 * Solve for current and voltage in V2
		 */
		iV2 = (v2/(reqR1R3 + r2));
		
		//solve for voltage in each resistor
		vV2R1 = (v2 - vV2R2);
		vV2R2 = (r2*iV2);
		vV2R3 =  vV2R1;
		
		//solve for current in each resistor
		iV2R1 = (vV2R1/r1);
		iV2R2 = (vV2R2/r2);
		iV2R3 = (vV2R3/r3);
		
		iTot = (iV1 - iV2);
		iTotR1 = (iV1R1 - iV2R1);
		iTotR2 = (iV1R2 - iV2R2);
		iTotR3 = (iV1R3 + iV2R3);
		vTotR1 = (vV1R1 - vV2R1);
		vTotR2 = (vV1R2 - vV2R2);
		vTotR3 = (vV1R3 + vV2R3);
		
		System.out.println("All values are calculated assuming v2 will be subtracted from v1 (v1 - v2).");
		System.out.println("Total Current: " + iTot);
		System.out.println("Current through R1: " + iTotR1);
		System.out.println("Current through R2: " + iTotR2);
		System.out.println("Current through R3: " + iTotR3);
		System.out.println("Voltage through R1: " + vTotR1);
		System.out.println("Voltage through R2: " + vTotR2);
		System.out.println("Voltage through R3: " + vTotR3);
		
		
		
		
		
	}
}
