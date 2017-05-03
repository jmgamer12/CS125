//UIUC CS125 FALL 2014 MP. File: MolecularApplet.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2015-11-17T19:16:54-0600.231687838
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JApplet;

/**
 * A Molecular viewer.
 * @author angrave
 *
 */
@SuppressWarnings("serial")
public class MolecularApplet extends JApplet {
	static final int ZOFFSET = 35;
	private static final int PRECESS = 4;
	private Image image;
	static double angle;

	Color [] colors;
	
	public void init() {
		rotatedXYZ = new double [moleculeXYZ.length][3];
		
		double center[] = {0,0,0};
		
		for(int i=0;i <moleculeXYZ.length;i++ )
			for(int j=0;j<3;j++)  center[j] += moleculeXYZ[i][j] / moleculeXYZ.length;
		
		for(int i=0;i <moleculeXYZ.length;i++ )
			for(int j=0;j<3;j++)  moleculeXYZ[i][j] -= center[j];
		
		colors = new Color[moleculeXYZ.length];
		for(int i=0;i <moleculeXYZ.length;i++) {
			float c = (float)i/rotatedXYZ.length; // color	
			colors[i]= Color.getHSBColor(0.5f, c,c );
		}
		
		setBackground(Color.LIGHT_GRAY );		
		setSize(300,300);
	}
	
	
	public void paint(Graphics greal) {
		if(image ==null || image.getWidth(null)!= getWidth() || image.getHeight(null)!=getHeight())
			image = createVolatileImage(getWidth(), getHeight());
		
		Graphics g=image.getGraphics();
		g.setColor(Color.LIGHT_GRAY );		
		g.fillRect(0,0,getWidth(),getHeight());
		angle+= 0.02; 
		if(angle>PRECESS * 2*Math.PI) angle -= PRECESS * 2*Math.PI;
		rotate(moleculeXYZ, rotatedXYZ,angle*Math.cos(angle/PRECESS), angle *Math.sin(angle/PRECESS));
		
		MolecularSort.sortCoordsByZ(rotatedXYZ);		
		
		for(int i=rotatedXYZ.length-1;i>=0;i--) {
			double[] pt =rotatedXYZ[i];
			
			double xx=pt[0],yy=pt[1],zz = ZOFFSET + pt[2];
			
			if(zz<=1) continue;
			int sx = (int) ((xx / zz  + 0.5) * getWidth()) ;
			int sy = (int) ((yy / zz  + 0.5) * getHeight());
									
			g.setColor(colors[i]);
			int r=2+ (int) (getWidth()/zz);//radius
			g.fillOval((int)sx,(int)sy, r, r);
			
			g.setColor(Color.WHITE);
			g.drawArc((int)sx,(int)sy, r, r,90,120);
		}
		g.dispose();
		greal.drawImage(image,0,0,this);
		repaint();
	}

	

	private void rotate(double [][]src,double [][]dest, double theta1,double theta2) {
		double c1= Math.cos(theta1),s1=Math.sin(theta1);
		double c2= Math.cos(theta2),s2=Math.sin(theta2);
		
		for(int i=0;i<src.length;i++) {
			double x=src[i][0],y=src[i][1],z=src[i][2];
			
			double x1=x * c1 - z * s1;
			double y1=y;
			double z1=z * c1 + x * s1;
			
			dest[i][0] = x1;
			dest[i][1] = y1 * c2 - z1 * s2;
			dest[i][2] = z1 * c2 + y1 * s2;
			
		}
	}
	
	double[][] rotatedXYZ;
	double[][] moleculeXYZ = {{-0.808,-8.873,-2.08},
			{-0.196,-10.198,-1.86},
			{-2.029,-8.583,-1.29},
			{0.27,-7.725,-1.83},
			{4.189,-7.682,-0.25},
			{2.252,-5.41,-0.47},
			{3.108,-4.88,-0.052},
			{2.035,-6.74,0.24},
			{2.42,-6.732,1.26},
			{0.982,-7.015,0.289},
			{2.818,-7.701,-0.64},
			{2.437,-8.72,-0.571},
			{2.608,-7.128,-2.04},
			{3.47,-7.426,-2.637},
			{1.364,-7.578,-2.77},
			{1.104,-6.836,-3.525},
			{1.561,-8.532,-3.258},
			{2.53,-5.682,-1.83},
			{-1.645,-0.802,-0.14},
			{-1.755,0.217,-0.042},
			{-2.476,-1.404,-0.23},
			{-0.417,-1.347,-0.15},
			{-0.191,-2.733,-0.28},
			{-1.049,-3.808,-0.43},
			{-0.253,-4.833,-0.5},
			{-0.608,-5.858,-0.612},
			{1.073,-4.504,-0.42},
			{1.112,-3.139,-0.28},
			{2.21,-2.37,-0.16},
			{1.868,-1.105,-0.04},
			{2.698,-0.407,0.067},
			{0.658,-0.554,-0.03},
			{4.562,-7.653,1.3},
			{5.836,-8.366,1.52},
			{3.403,-8.136,2.09},
			{4.759,-6.091,1.55},
			{7.904,-3.753,3.13},
			{5.002,-3.053,2.91},
			{5.383,-2.121,3.328},
			{5.608,-4.257,3.62},
			{5.915,-4.024,4.64},
			{4.918,-5.099,3.669},
			{6.806,-4.574,2.74},
			{7.097,-5.622,2.809},
			{6.3,-4.234,1.34},
			{7.172,-3.968,0.743},
			{5.558,-5.329,0.61},
			{4.911,-4.882,-0.145},
			{6.278,-5.985,0.122},
			{5.387,-3.11,1.55},
			{-0.508,-2.712,3.11},
			{-1.1,-3.551,3.036},
			{-0.94,-1.785,3.223},
			{0.81,-2.827,3.06},
			{1.548,-1.714,3.16},
			{2.902,-1.771,3.11},
			{3.611,-0.761,3.2},
			{3.515,-3.013,2.96},
			{2.775,-4.147,2.86},
			{3.281,-5.104,2.737},
			{1.416,-4.113,2.91},
			{0.819,-5.022,2.839},
			{8.189,-3.51,4.68},
			{9.638,-3.338,4.9},
			{7.536,-4.582,5.47},
			{7.43,-2.13,4.93},
			{8.6,1.61,6.51},
			{5.841,0.47,6.29},
			{5.602,1.448,6.708},
			{7.039,-0.147,7},
			{7.15,0.221,8.02},
			{6.975,-1.234,7.049},
			{8.195,0.3,6.12},
			{9.046,-0.377,6.189},
			{7.585,0.278,4.72},
			{8.134,1.006,4.123},
			{7.629,-1.044,3.99},
			{6.843,-1.063,3.235},
			{8.597,-1.152,3.502},
			{6.186,0.65,4.93},
			{0.254,-1.812,6.62},
			{-0.749,-1.602,6.718},
			{0.57,-2.789,6.53},
			{1.152,-0.813,6.61},
			{2.54,-1.026,6.48},
			{3.297,-2.174,6.33},
			{4.518,-1.734,6.26},
			{5.383,-2.388,6.148},
			{4.615,-0.371,6.34},
			{3.329,0.088,6.48},
			{2.937,1.369,6.6},
			{1.628,1.435,6.72},
			{1.221,2.44,6.827},
			{0.73,0.455,6.73},
			{8.688,1.973,8.06},
			{9.759,2.965,8.28},
			{8.79,0.723,8.85},
			{7.263,2.644,8.31},
			{6.012,6.358,9.89},
			{4.449,3.814,9.67},
			{3.681,4.464,10.088},
			{5.781,4.018,10.38},
			{5.655,4.382,11.4},
			{6.369,3.101,10.429},
			{6.453,5.06,9.5},
			{7.54,5.013,9.569},
			{5.973,4.683,8.1},
			{5.99,5.595,7.503},
			{6.786,3.639,7.37},
			{6.16,3.162,6.615},
			{7.632,4.121,6.882},
			{4.622,4.162,8.31},
			{1.271,-1.317,10},
			{0.336,-1.736,10.098},
			{2.1,-1.921,9.91},
			{1.41,0.02,9.99},
			{2.658,0.663,9.86},
			{3.946,0.179,9.71},
			{4.675,1.253,9.64},
			{5.759,1.232,9.528},
			{3.952,2.412,9.72},
			{2.642,2.028,9.86},
			{1.571,2.834,9.98},
			{0.474,2.118,10.1},
			{-0.447,2.692,10.207},
			{0.324,0.797,10.11},
			{5.869,6.703,11.44},
			{6.153,8.135,11.66},
			{6.686,5.751,12.23},
			{4.322,6.408,11.69},
			{1.126,8.677,13.27},
			{1.358,5.7,13.05},
			{0.354,5.775,13.468},
			{2.315,6.649,13.76},
			{1.999,6.869,14.78},
			{3.329,6.252,13.809},
			{2.247,7.887,12.88},
			{3.154,8.487,12.949},
			{2.08,7.3,11.48},
			{1.557,8.047,10.883},
			{3.351,6.932,10.75},
			{3.125,6.18,9.995},
			{3.752,7.82,10.262},
			{1.293,6.084,11.69},
			{-2.299,1.943,13.62},
			{-2.894,2.784,13.627},
			{-2.726,1.01,13.713},
			{1.681,-0.315,13.39},
			{1.143,0.792,13.37},
			{1.735,2.068,13.24},
			{3.077,2.43,13.1},
			{3.046,3.735,13.02},
			{3.943,4.343,12.901},
			{1.779,4.275,13.1},
			{0.934,3.196,13.24},
			{-0.418,3.263,13.36},
			{-0.974,2.061,13.49},
			{-0.255,0.884,13.49},
			{-0.783,0.005,13.585},
			{0.808,8.873,14.82},
			{0.196,10.198,15.04},
			{2.029,8.583,15.61},
			{-0.27,7.725,15.07},
			{-4.189,7.682,16.65},
			{-2.252,5.41,16.43},
			{-3.108,4.88,16.848},
			{-2.035,6.74,17.14},
			{-2.42,6.732,18.16},
			{-0.982,7.015,17.189},
			{-2.818,7.701,16.26},
			{-2.437,8.72,16.329},
			{-2.608,7.128,14.86},
			{-3.47,7.426,14.263},
			{-1.364,7.578,14.13},
			{-1.104,6.836,13.375},
			{-1.561,8.532,13.642},
			{-2.53,5.682,15.07},
			{1.645,0.802,16.76},
			{1.755,-0.217,16.858},
			{2.476,1.404,16.67},
			{0.417,1.347,16.75},
			{0.191,2.733,16.62},
			{1.049,3.808,16.47},
			{0.253,4.833,16.4},
			{0.608,5.858,16.288},
			{-1.073,4.504,16.48},
			{-1.112,3.139,16.62},
			{-2.21,2.37,16.74},
			{-1.868,1.105,16.86},
			{-2.698,0.407,16.967},
			{-0.658,0.554,16.87},
			{-4.562,7.653,18.2},
			{-5.836,8.366,18.42},
			{-3.403,8.136,18.99},
			{-4.759,6.091,18.45},
			{-7.904,3.753,20.03},
			{-5.002,3.053,19.81},
			{-5.383,2.121,20.228},
			{-5.608,4.257,20.52},
			{-5.915,4.024,21.54},
			{-4.918,5.099,20.569},
			{-6.806,4.574,19.64},
			{-7.097,5.622,19.709},
			{-6.3,4.234,18.24},
			{-7.172,3.968,17.643},
			{-5.558,5.329,17.51},
			{-4.911,4.882,16.755},
			{-6.278,5.985,17.022},
			{-5.387,3.11,18.45},
			{0.859,1.616,20.14},
			{1.548,0.856,20.238},
			{1.178,2.591,20.05},
			{-0.454,1.335,20.13},
			{-1.452,2.323,20},
			{-1.39,3.697,19.85},
			{-2.636,4.059,19.78},
			{-2.951,5.096,19.668},
			{-3.515,3.013,19.86},
			{-2.745,1.886,20},
			{-3.181,0.618,20.12},
			{-2.161,-0.204,20.24},
			{-2.422,-1.257,20.347},
			{-0.858,0.061,20.25},
			{-8.189,3.51,21.58},
			{-9.638,3.338,21.8},
			{-7.536,4.582,22.37},
			{-7.43,2.13,21.83},
			{-8.6,-1.61,23.41},
			{-5.841,-0.47,23.19},
			{-5.602,-1.448,23.608},
			{-7.039,0.147,23.9},
			{-7.15,-0.221,24.92},
			{-6.975,1.234,23.949},
			{-8.195,-0.3,23.02},
			{-9.046,0.377,23.089},
			{-7.585,-0.278,21.62},
			{-8.134,-1.006,21.023},
			{-7.629,1.044,20.89},
			{-6.843,1.063,20.135},
			{-8.597,1.152,20.402},
			{-6.186,-0.65,21.83},
			{-1.184,2.493,23.39},
			{-1.197,3.52,23.316},
			{-0.288,1.996,23.503},
			{-2.317,1.811,23.34},
			{-2.26,0.477,23.44},
			{-3.389,-0.273,23.39},
			{-3.369,-1.507,23.48},
			{-4.615,0.371,23.24},
			{-4.683,1.723,23.14},
			{-5.655,2.201,23.017},
			{-3.563,2.495,23.19},
			{-3.614,3.582,23.119},
			{-8.688,-1.973,24.96},
			{-9.759,-2.965,25.18},
			{-8.79,-0.723,25.75},
			{-7.263,-2.644,25.21},
			{-6.012,-6.358,26.79},
			{-4.449,-3.814,26.57},
			{-3.681,-4.464,26.988},
			{-5.781,-4.018,27.28},
			{-5.655,-4.382,28.3},
			{-6.369,-3.101,27.329},
			{-6.453,-5.06,26.4},
			{-7.54,-5.013,26.469},
			{-5.973,-4.683,25},
			{-5.99,-5.595,24.403},
			{-6.786,-3.639,24.27},
			{-6.16,-3.162,23.515},
			{-7.632,-4.121,23.782},
			{-4.622,-4.162,25.21},
			{-2.483,1.337,26.77},
			{-2.973,0.203,26.72},
			{-2.176,-0.914,26.81},
			{-1.165,-0.753,26.918},
			{-2.593,-2.23,26.77},
			{-1.809,-3.159,26.86},
			{-3.952,-2.412,26.62},
			{-4.823,-1.356,26.52},
			{-5.889,-1.548,26.398},
			{-4.379,-0.084,26.57},
			{-5.286,1.105,26.46},
			{-4.689,2.015,26.42},
			{-5.884,1.023,25.552},
			{-5.946,1.141,27.327},
			{-5.869,-6.703,28.34},
			{-6.153,-8.135,28.56},
			{-6.686,-5.751,29.13},
			{-4.322,-6.408,28.59},
			{-1.126,-8.677,30.17},
			{-1.358,-5.7,29.95},
			{-0.354,-5.775,30.368},
			{-2.315,-6.649,30.66},
			{-1.999,-6.869,31.68},
			{-3.329,-6.252,30.709},
			{-2.247,-7.887,29.78},
			{-3.154,-8.487,29.849},
			{-2.08,-7.3,28.38},
			{-1.557,-8.047,27.783},
			{-3.351,-6.932,27.65},
			{-3.125,-6.18,26.895},
			{-3.752,-7.82,27.162},
			{-1.293,-6.084,28.59},
			{-1.802,0.318,30.28},
			{-1.292,1.208,30.378},
			{-2.828,0.32,30.19},
			{-1.129,-0.845,30.27},
			{-1.761,-2.099,30.14},
			{-3.087,-2.464,29.99},
			{-3.045,-3.761,29.92},
			{-3.935,-4.382,29.808},
			{-1.779,-4.275,30},
			{-0.945,-3.193,30.14},
			{0.395,-3.216,30.26},
			{0.862,-1.992,30.38},
			{1.944,-1.915,30.487},
			{0.207,-0.835,30.39},
			{4.562,7.653,32.5},
			{5.836,8.366,32.28},
			{3.403,8.136,31.71},
			{4.759,6.091,32.25},
			{7.904,3.753,30.67},
			{5.002,3.053,30.89},
			{5.383,2.121,30.472},
			{5.608,4.257,30.18},
			{5.915,4.024,29.16},
			{4.918,5.099,30.131},
			{6.806,4.574,31.06},
			{7.097,5.622,30.991},
			{6.3,4.234,32.46},
			{7.172,3.968,33.057},
			{5.558,5.329,33.19},
			{4.911,4.882,33.945},
			{6.278,5.985,33.679},
			{5.387,3.11,32.25},
			{-0.505,2.774,30.69},
			{0.726,2.891,30.74},
			{1.542,1.787,30.65},
			{1.076,0.875,30.542},
			{2.922,1.777,30.69},
			{3.563,0.745,30.6},
			{3.515,3.013,30.84},
			{2.78,4.168,30.94},
			{3.292,5.122,31.062},
			{1.434,4.139,30.89},
			{0.583,5.369,31},
			{1.221,6.252,31.014},
			{-0.092,5.422,30.146},
			{0.001,5.327,31.92},
			{8.189,3.51,29.12},
			{9.638,3.338,28.9},
			{7.536,4.582,28.33},
			{7.43,2.13,28.87},
			{8.6,-1.61,27.29},
			{5.841,-0.47,27.51},
			{5.602,-1.448,27.092},
			{7.039,0.147,26.8},
			{7.15,-0.221,25.78},
			{6.975,1.234,26.751},
			{8.195,-0.3,27.68},
			{9.046,0.377,27.611},
			{7.585,-0.278,29.08},
			{8.134,-1.006,29.677},
			{7.629,1.045,29.81},
			{6.843,1.063,30.565},
			{8.597,1.152,30.299},
			{6.186,-0.65,28.87},
			{0.254,1.812,27.18},
			{-0.749,1.602,27.082},
			{0.57,2.789,27.27},
			{1.152,0.813,27.19},
			{2.54,1.026,27.32},
			{3.297,2.174,27.47},
			{4.518,1.734,27.54},
			{5.383,2.388,27.652},
			{4.615,0.371,27.46},
			{3.329,-0.088,27.32},
			{2.937,-1.369,27.2},
			{1.628,-1.435,27.08},
			{1.221,-2.44,26.973},
			{0.73,-0.455,27.07},
			{8.688,-1.973,25.74},
			{9.759,-2.965,25.52},
			{8.79,-0.723,24.95},
			{7.263,-2.644,25.49},
			{6.012,-6.358,23.91},
			{4.449,-3.814,24.13},
			{3.681,-4.464,23.712},
			{5.781,-4.018,23.42},
			{5.655,-4.382,22.4},
			{6.369,-3.101,23.371},
			{6.453,-5.06,24.3},
			{7.54,-5.012,24.231},
			{5.973,-4.683,25.7},
			{5.99,-5.595,26.297},
			{6.786,-3.639,26.43},
			{6.16,-3.162,27.185},
			{7.632,-4.121,26.919},
			{4.622,-4.162,25.49},
			{-0.718,-2.923,23.56},
			{-0.705,-3.953,23.553},
			{-1.612,-2.419,23.467},
			{1.175,1.243,23.79},
			{1.39,0.031,23.81},
			{2.619,-0.653,23.94},
			{3.917,-0.157,24.08},
			{4.66,-1.231,24.16},
			{5.742,-1.196,24.279},
			{3.952,-2.412,24.08},
			{2.635,-2.037,23.94},
			{1.58,-2.885,23.82},
			{0.423,-2.24,23.69},
			{0.313,-0.865,23.69},
			{-0.631,-0.464,23.595},
			{5.869,-6.703,22.36},
			{6.153,-8.135,22.14},
			{6.686,-5.751,21.57},
			{4.322,-6.408,22.11},
			{1.126,-8.677,20.53},
			{1.358,-5.7,20.75},
			{0.354,-5.775,20.332},
			{2.315,-6.649,20.04},
			{1.999,-6.869,19.02},
			{3.329,-6.252,19.991},
			{2.247,-7.887,20.92},
			{3.154,-8.487,20.851},
			{2.08,-7.3,22.32},
			{1.557,-8.047,22.917},
			{3.351,-6.932,23.05},
			{3.125,-6.18,23.805},
			{3.752,-7.82,23.539},
			{1.293,-6.084,22.11},
			{2.795,-0.377,20.55},
			{2.525,-1.583,20.6},
			{1.223,-2.019,20.51},
			{0.5,-1.293,20.402},
			{0.787,-3.328,20.55},
			{-0.393,-3.619,20.46},
			{1.779,-4.274,20.7},
			{3.105,-3.932,20.8},
			{3.854,-4.714,20.922},
			{3.493,-2.642,20.75},
			{4.926,-2.213,20.86},
			{5.569,-3.093,20.874},
			{5.185,-1.588,20.006},
			{5.066,-1.647,21.78},
			{0.808,-8.873,18.98},
			{0.196,-10.198,18.76},
			{2.029,-8.583,18.19},
			{-0.27,-7.725,18.73},
			{-4.189,-7.682,17.15},
			{-2.252,-5.41,17.37},
			{-3.108,-4.88,16.952},
			{-2.035,-6.74,16.66},
			{-2.42,-6.732,15.64},
			{-0.982,-7.015,16.611},
			{-2.818,-7.701,17.54},
			{-2.437,-8.72,17.471},
			{-2.608,-7.128,18.94},
			{-3.47,-7.426,19.537},
			{-1.364,-7.578,19.67},
			{-1.104,-6.836,20.425},
			{-1.561,-8.532,20.159},
			{-2.53,-5.682,18.73},
			{2.039,-1.948,17.17},
			{1.112,-2.765,17.22},
			{-0.197,-2.352,17.13},
			{-0.356,-1.34,17.022},
			{-1.32,-3.155,17.17},
			{-2.445,-2.697,17.08},
			{-1.073,-4.504,17.32},
			{0.201,-5.006,17.42},
			{0.347,-6.079,17.542},
			{1.273,-4.191,17.37},
			{2.684,-4.686,17.48},
			{2.687,-5.776,17.494},
			{3.261,-4.332,16.626},
			{3.131,-4.31,18.4},
			{-4.562,-7.653,15.6},
			{-5.836,-8.366,15.38},
			{-3.403,-8.136,14.81},
			{-4.759,-6.091,15.35},
			{-7.904,-3.753,13.77},
			{-5.002,-3.053,13.99},
			{-5.383,-2.121,13.572},
			{-5.608,-4.257,13.28},
			{-5.915,-4.024,12.26},
			{-4.918,-5.099,13.231},
			{-6.806,-4.574,14.16},
			{-7.097,-5.622,14.091},
			{-6.3,-4.234,15.56},
			{-7.172,-3.968,16.157},
			{-5.558,-5.329,16.29},
			{-4.911,-4.882,17.045},
			{-6.278,-5.985,16.779},
			{-5.387,-3.11,15.35},
			{0.508,-2.712,13.79},
			{1.1,-3.551,13.864},
			{0.94,-1.785,13.677},
			{-0.81,-2.827,13.84},
			{-1.548,-1.714,13.74},
			{-2.902,-1.771,13.79},
			{-3.611,-0.761,13.7},
			{-3.515,-3.013,13.94},
			{-2.775,-4.147,14.04},
			{-3.281,-5.104,14.163},
			{-1.416,-4.113,13.99},
			{-0.819,-5.022,14.061},
			{-8.189,-3.51,12.22},
			{-9.638,-3.338,12},
			{-7.536,-4.582,11.43},
			{-7.43,-2.13,11.97},
			{-8.6,1.61,10.39},
			{-5.841,0.47,10.61},
			{-5.602,1.448,10.192},
			{-7.039,-0.147,9.9},
			{-7.15,0.221,8.88},
			{-6.975,-1.234,9.851},
			{-8.195,0.3,10.78},
			{-9.046,-0.377,10.711},
			{-7.585,0.278,12.18},
			{-8.134,1.006,12.777},
			{-7.629,-1.044,12.91},
			{-6.843,-1.063,13.665},
			{-8.597,-1.152,13.399},
			{-6.186,0.65,11.97},
			{-1.223,-2.541,10.41},
			{-2.286,-1.912,10.46},
			{-2.298,-0.539,10.37},
			{-1.385,-0.076,10.262},
			{-3.408,0.28,10.41},
			{-3.321,1.492,10.32},
			{-4.615,-0.371,10.56},
			{-4.699,-1.738,10.66},
			{-5.674,-2.209,10.782},
			{-3.593,-2.506,10.61},
			{-3.627,-4.001,10.72},
			{-4.663,-4.341,10.734},
			{-3.112,-4.44,9.866},
			{-3.132,-4.309,11.64},
			{-8.688,1.973,8.84},
			{-9.759,2.965,8.62},
			{-8.79,0.723,8.05},
			{-7.263,2.644,8.59},
			{-6.012,6.358,7.01},
			{-4.449,3.814,7.23},
			{-3.681,4.464,6.812},
			{-5.781,4.018,6.52},
			{-5.655,4.382,5.5},
			{-6.369,3.101,6.471},
			{-6.453,5.06,7.4},
			{-7.54,5.013,7.331},
			{-5.973,4.683,8.8},
			{-5.99,5.595,9.397},
			{-6.786,3.639,9.53},
			{-6.16,3.163,10.285},
			{-7.632,4.121,10.019},
			{-4.622,4.162,8.59},
			{-2.483,-1.337,7.03},
			{-2.973,-0.203,7.08},
			{-2.176,0.914,6.99},
			{-1.165,0.753,6.882},
			{-2.593,2.23,7.03},
			{-1.809,3.159,6.94},
			{-3.952,2.412,7.18},
			{-4.823,1.356,7.28},
			{-5.889,1.548,7.402},
			{-4.379,0.084,7.23},
			{-5.286,-1.105,7.34},
			{-6.324,-0.771,7.354},
			{-5.128,-1.763,6.486},
			{-5.067,-1.646,8.26},
			{-5.869,6.703,5.46},
			{-6.153,8.135,5.24},
			{-6.686,5.751,4.67},
			{-4.322,6.408,5.21},
			{-1.126,8.677,3.63},
			{-1.358,5.7,3.85},
			{-0.354,5.775,3.432},
			{-2.315,6.649,3.14},
			{-1.999,6.869,2.12},
			{-3.329,6.253,3.091},
			{-2.247,7.887,4.02},
			{-3.154,8.487,3.951},
			{-2.08,7.3,5.42},
			{-1.557,8.047,6.017},
			{-3.351,6.932,6.15},
			{-3.125,6.18,6.905},
			{-3.752,7.82,6.639},
			{-1.293,6.084,5.21},
			{2.299,1.943,3.28},
			{2.894,2.784,3.273},
			{2.726,1.01,3.187},
			{-1.681,-0.315,3.51},
			{-1.143,0.792,3.53},
			{-1.735,2.068,3.66},
			{-3.077,2.43,3.8},
			{-3.046,3.735,3.88},
			{-3.943,4.343,3.999},
			{-1.779,4.275,3.8},
			{-0.934,3.196,3.66},
			{0.418,3.263,3.54},
			{0.974,2.061,3.41},
			{0.255,0.884,3.41},
			{0.783,0.005,3.315},
			{-0.808,8.873,2.08},
			{-0.196,10.198,1.86},
			{-2.029,8.583,1.29},
			{0.27,7.725,1.83},
			{4.189,7.682,0.25},
			{2.252,5.41,0.47},
			{3.108,4.88,0.052},
			{2.035,6.74,-0.24},
			{2.42,6.732,-1.26},
			{0.982,7.015,-0.289},
			{2.818,7.701,0.64},
			{2.437,8.72,0.571},
			{2.608,7.128,2.04},
			{3.47,7.426,2.637},
			{1.364,7.578,2.77},
			{1.104,6.836,3.525},
			{1.561,8.532,3.259},
			{2.53,5.682,1.83},
			{-2.039,1.948,0.27},
			{-1.112,2.765,0.32},
			{0.197,2.352,0.23},
			{0.356,1.34,0.122},
			{1.32,3.155,0.27},
			{2.445,2.697,0.18},
			{1.073,4.504,0.42},
			{-0.201,5.006,0.52},
			{-0.347,6.079,0.642},
			{-1.273,4.191,0.47},
			{-2.684,4.686,0.58},
			{-2.687,5.776,0.594},
			{-3.261,4.332,-0.274},
			{-3.131,4.31,1.5}};

}
