/*
 * The MIT License
 *
 * Copyright 2016 Mentor Graphics.
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
package com.mentor.questa.vrm.jenkins;


import com.mentor.questa.ucdb.jenkins.CoverageUtil;
import hudson.Extension;
import hudson.model.Descriptor;
import hudson.model.TopLevelItem;
import hudson.plugins.view.dashboard.DashboardPortlet;
import java.util.ArrayList;
import java.util.List;
import jenkins.model.Jenkins;
import org.kohsuke.stapler.DataBoundConstructor;


/**
 *
 * 
 */
public class QuestaVrmPortlet extends DashboardPortlet {
    @DataBoundConstructor
    public QuestaVrmPortlet(String name) {
        super(name);
    }
    
    public List<String> getCoverageColumnHeaders() {     
        return CoverageUtil.getCoverageSummaryHeaders();
    }
    
    public List<CoverageUtil.RowItem> getRow(TopLevelItem job) {
        return CoverageUtil.getLastCoverageResult(job);
    }


    @Override
    public String getDisplayName() {
        return super.getDisplayName(); 
    }
    

    @Extension
    public static class DescriptorImpl extends Descriptor<DashboardPortlet> {

        @Override
        public String getDisplayName() {
            return "Questa Coverage Portlet";
        }
    }

}
