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
//SYSTEM:    Practical Peer Model Toolchain "for the poor woman/man"
//AUTHOR:    Eva Maria Kuehn
//CREATED:   December 2020 
//================================================================================

package codeGen.PmDsl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import qa.exceptions.CodeGenException;
import qa.exceptions.SNHException;
import qa.tracer.O;

//================================================================================
// WRITE CODE TO FILE
//================================================================================
// file management 
//--------------------------------------------------------------------------------
public class PmDslCodeWriter extends codeGen.BasicCodeWriter {
	//--------------------------------------------------------------------------------
	// file:
	File output_File; 
	//--------------------------------------------------------------------------------
	// file writer:
	BufferedWriter output_FileWriter;
	// - set current one 
	//--------------------------------------------------------------------------------
	// file name:
	String output_FileName = "";

	//================================================================================
	// CONSTRUCTORS
	//================================================================================
	//--------------------------------------------------------------------------------
	public PmDslCodeWriter(String useCaseAndConfigName, String absoluteUcTargetPath, boolean writeAlsoToConsoleFlag) {	
		super(useCaseAndConfigName, absoluteUcTargetPath, writeAlsoToConsoleFlag);
	}

	//================================================================================
	// CREATE/OPEN DIRECTORIES/FILES FOR GO CODE GENERATION
	//================================================================================
	//--------------------------------------------------------------------------------
	// create & open files
	//--------------------------------------------------------------------------------
	public void openFiles() throws CodeGenException {
		//--------------------------------------------------------------------------------
		/**/ O m = new O(){}; // debug
		//--------------------------------------------------------------------------------
		try {
			//================================================================================
			// CREATE DIRECTORIES 
			//================================================================================
			// create also intermediadiary directories
			java.nio.file.Files.createDirectories(Paths.get(super.absoluteUcTargetPath));
			//================================================================================
			// CREATE FILES & SET FILE NAMES 
			//================================================================================
			//--------------------------------------------------------------------------------
			// <useCaseAndConfigName>_PM_DSL.xml
			output_FileName = absoluteUcTargetPath + "" + useCaseAndConfigName + "_PM_DSL.xml";
			output_FileWriter = openAutoFile(output_FileName); 
			//--------------------------------------------------------------------------------
			cur_BufferedWriter = output_FileWriter;
		} catch (IOException e) {
			throw new CodeGenException("FILE ERROR: " + e.getMessage(), m);
		} catch (CodeGenException e) {
			// do not try to close files... causes exception
			throw new CodeGenException("FILE ERROR", m, e);
		}
	}

	//================================================================================
	// SWITCH FILE
	//================================================================================
	//--------------------------------------------------------------------------------
	// switch to file id (see defines)
	public void switch2File(int fileId) throws SNHException {
		//--------------------------------------------------------------------------------
		/**/ O m = new O(){}; // debug
		//--------------------------------------------------------------------------------
		switch(fileId) {
		case PmDslDefs.DSL_XML_FILE_ID:
			cur_BufferedWriter = output_FileWriter;
			break;
		default:
			throw new SNHException(448266, "ill. fileId = " + fileId, m);
		}			
		curFileId = fileId;
	}

	//================================================================================
	// QUERY
	//================================================================================
	//--------------------------------------------------------------------------------
	// return info about file id (see defines)
	public String fileId2Info(int fileId) throws SNHException {
		//--------------------------------------------------------------------------------
		/**/ O m = new O(){}; // debug
		//--------------------------------------------------------------------------------
		switch(fileId) {
		case PmDslDefs.DSL_XML_FILE_ID:
			return(output_FileName);
		default:
			throw new SNHException(926345, "ill. fileId = " + fileId, m);
		}			
	}
	
	//================================================================================
	// CLOSE ALL FILES
	//================================================================================
	// close files
	public void closeFiles() throws SNHException {
		//--------------------------------------------------------------------------------
		/**/ O m = new O(){}; // debug
		//--------------------------------------------------------------------------------
		try {
			if(output_FileWriter != null)
				output_FileWriter.close();
		} catch (IOException e) {
			throw new SNHException(236525, "i/o error" + e.getMessage(), m);
		}
	}


} // END OF CLASS


//================================================================================
// EOF
//================================================================================
