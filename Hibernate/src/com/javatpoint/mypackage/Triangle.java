package com.javatpoint.mypackage;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.javafx.scene.paint.GradientUtils.Point;

@Entity
	@Table(name="triangle")
	
	public class Triangle implements Figure
	{
		
		//properties
		
		@Id
		
		private int id;
		private String tname;
		private float tarea;
		
		private Point  A;
		
		private Point B;
		
		private Point c;
		
		
		
		
		
		
		
		
		
		
	}

}
