package org.xtext.example.mydsl1.validation

import org.xtext.example.mydsl1.sQLEXAM.MathExp
import org.xtext.example.mydsl1.sQLEXAM.Expression
import org.xtext.example.mydsl1.sQLEXAM.Numbers
import org.xtext.example.mydsl1.sQLEXAM.Plus
import org.xtext.example.mydsl1.sQLEXAM.Minus
import org.xtext.example.mydsl1.sQLEXAM.Mult
import org.xtext.example.mydsl1.sQLEXAM.Div
import org.xtext.example.mydsl1.sQLEXAM.Parenthesis
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.XtextPackage.Literals;
import org.xtext.example.mydsl1.sQLEXAM.Add

class SQLEXAMVALIDATE extends AbstractSQLEXAMValidator {
	
	
	def int generate(MathExp gen) {
		gen.exp.generateExp
	}
		
	def dispatch int generateExp(Expression exp) { exp.exp1.generateExp }
	def dispatch int generateExp(Numbers exp) { exp.value }
	
	def dispatch int generateExp(Plus exp) { 
		exp.exp1.generateExp+exp.exp2.generateExp
	}
	def dispatch int generateExp(Minus exp) {
		exp.exp1.generateExp-exp.exp2.generateExp
	}
	
	def dispatch int generateExp(Mult exp) { 
		exp.exp1.generateExp*exp.exp2.generateExp
	}
	def dispatch int generateExp(Div exp) { 
		exp.exp1.generateExp/exp.exp2.generateExp
	}
	
	def dispatch int generateExp(Parenthesis parenthesis){
		 parenthesis.exp.generateExp
	}
	
	
	// Method to define that age cannot exceed 100 when adding a person
	def void restrictAge(Add entity){
		for (i : 0 ..< entity.attributes.length) {
			if(entity.attributes.get(i).name == "age"){
				var age = generateExp(entity.attributes.get(i).requirement1.right)
			if(age > 100){
			warning("Are you sure that this person is above 100 years old?", null)
			}
			}
		}
	}
	
	
	@Check
	def someWarning(){
		error("woo",null)
	}
	
}