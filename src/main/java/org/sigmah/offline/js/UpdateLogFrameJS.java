package org.sigmah.offline.js;

/*
 * #%L
 * Sigmah
 * %%
 * Copyright (C) 2010 - 2016 URD
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import org.sigmah.shared.command.UpdateLogFrame;
import org.sigmah.shared.dto.logframe.LogFrameDTO;

/**
 * JavaScript version of the {@link UpdateLogFrame} command.
 * 
 * @author Raphaël Calabro (rcalabro@ideia.fr)
 */
public final class UpdateLogFrameJS extends CommandJS {
	
	protected UpdateLogFrameJS() {
	}
	
	public static UpdateLogFrameJS toJavaScript(UpdateLogFrame updateLogFrame) {
		final UpdateLogFrameJS updateLogFrameJS = Values.createJavaScriptObject(UpdateLogFrameJS.class);
		
		updateLogFrameJS.setProjectId(updateLogFrame.getProjectId());
		updateLogFrameJS.setLogFrame(updateLogFrame.getLogFrame());
		
		return updateLogFrameJS;
	}
	
	public UpdateLogFrame toUpdateLogFrame() {
		return new UpdateLogFrame(getLogFrameDTO(), getProjectId());
	}
	
	public Integer getProjectId() {
		return Values.getInteger(this, "projectId");
	}
	
	public void setProjectId(Integer projectId) {
		Values.setInteger(this, "projectId", projectId);
	}
	
	public native LogFrameJS getLogFrame() /*-{
		return this.logFrame;
	}-*/;
	
	public native void setLogFrame(LogFrameJS logFrame) /*-{
		this.logFrame = logFrame;
	}-*/;
	
	public LogFrameDTO getLogFrameDTO() {
		if(getLogFrame() != null) {
			return getLogFrame().toDTO();
		}
		return null;
	}
	
	public void setLogFrame(LogFrameDTO logFrameDTO) {
		if(logFrameDTO != null) {
			setLogFrame(LogFrameJS.toJavaScript(logFrameDTO));
		}
	}
}
