//================================================================================
// Peer Model Tool Chain
// Copyright (C) 2021 Eva Maria Kuehn
//--------------------------------------------------------------------------------
// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU Affero General Public License as
// published by the Free Software Foundation, either version 3 of the
// License, or (at your option) any later version.
// 
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Affero General Public License for more details.
// 
// You should have received a copy of the GNU Affero General Public License
// along with this program.  If not, see <http://www.gnu.org/licenses/>.
//================================================================================
// SYSTEM:    Practical Peer Model Toolchain "for the poor woman/man"
// AUTHOR:    Eva Maria Kuehn
// CREATED:   January 2021 
//================================================================================
// CODE REVIEWS: 
//================================================================================

package codeGen;

import qa.exceptions.CodeGenException;
import qa.exceptions.SNHException;

//================================================================================
public interface IBasicCodeGen {
	//-------------------------------------------------------------------------------
	// methods
	// - generate code from PMMM 
	public void generateUcCode() throws CodeGenException, SNHException;
	//-------------------------------------------------------------------------------
	
} // END OF INTERFACE


//================================================================================
// EOF
//================================================================================