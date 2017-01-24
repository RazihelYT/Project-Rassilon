/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Doctor Squawk
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.pekkit.projectrassilon.api;

import net.pekkit.projectrassilon.ProjectRassilon;
import net.pekkit.projectrassilon.RegenManager;
import net.pekkit.projectrassilon.data.TimelordDataHandler;

/**
 * This is the API other plugins can use to hook into Project Rassilon.
 *
 * @author Squawkers13
 */
public class RassilonAPI {

    private final ProjectRassilon plugin;
    private final TimelordDataHandler tdh;
    private final RegenManager rm;

    private final TimelordDataManager tdm;
    private final Regenerator tr;

    public RassilonAPI(ProjectRassilon par1, TimelordDataHandler par2, RegenManager rm) {
        plugin = par1;
        tdh = par2;
        this.rm = rm;

        tdm = new TimelordDataManager(tdh);
        tr = new Regenerator(plugin, tdh, rm);
    }

    /**
     * Fetch an instance of the Timelord Data Manager.
     * @return the Timelord Data Manager
     */
    public TimelordDataManager getTimelordDataManager() {
        return tdm;
    }

    /**
     * Fetch an instance of the Regenerator.
     * @return the Regenerator
     */
    public Regenerator getRegenerator() {
        return tr;
    }

}
