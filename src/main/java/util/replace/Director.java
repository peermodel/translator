//================================================================================
//Peer Model Tool Chain
//Copyright (C) 2021 Eva Maria Kuehn
//--------------------------------------------------------------------------------
//This program is free software: you can redistribute it and/or modify
//it under the terms of the GNU Affero General Public License as
//published by the Free Software Foundation, either version 3 of the
//License, or (at your option) any later version.
//
//This program is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU Affero General Public License for more details.
//
//You should have received a copy of the GNU Affero General Public License
//along with this program.  If not, see <http://www.gnu.org/licenses/>.
//================================================================================
// SYSTEM:    Practical Peer Model Toolchain "for the poor woman/man"
// AUTHOR:    Eva Maria Kuehn
// CREATED:   January 2021
//================================================================================
// CODE REVIEWS: 
//================================================================================

package util.replace;

import qa.tracer.Tracer;


//================================================================================
// for builder pattern for replacements
public class Director {
	//--------------------------------------------------------------------------------
	// for debugging
	Tracer tracer = new Tracer();
	//--------------------------------------------------------------------------------
	// actual replacer, initialized with the desired replacements
	Replacements replacements = new Replacements();

	//================================================================================
	// CONSTRUCTORS
	//================================================================================
	//--------------------------------------------------------------------------------
	// pass your preferred replacements here
	public Director(Replacements replacements) {
		this.replacements = replacements;
	}
	
	//================================================================================
	// SET
	//================================================================================
	//--------------------------------------------------------------------------------
	public void setReplacements(Replacements replacements) {
		this.replacements = replacements;
	}
	
	//================================================================================
	// CALL THE RIGHT REPLACEMENT MECHANISM
	//================================================================================
	//--------------------------------------------------------------------------------
	public String string2X(String s) {
		return replacements.string2X(s);
	}
	//--------------------------------------------------------------------------------
	public String x2String(String s) {
		return replacements.x2String(s);
	}
	
	
} // END OF CLASS


//================================================================================
// EOF
//================================================================================
