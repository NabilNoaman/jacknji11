/*
 * Copyright 2010-2011 Joel Hockey (joel.hockey@gmail.com). All rights reserved.
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

package org.pkcs11.jacknji11.jffi;

import jnr.ffi.Struct;

import org.pkcs11.jacknji11.CK_SLOT_INFO;

/**
 * JFFI wrapper for PKCS#11 CK_SLOT_INFO struct.
 * @author Joel Hockey (joel.hockey@gmail.com)
 */
public class JFFI_CK_SLOT_INFO extends Struct {
    public byte[] slotDescription;
    public byte[] manufacturerID;
    public long flags;
    public JFFI_CK_VERSION hardwareVersion;
    public JFFI_CK_VERSION firmwareVersion;

    public JFFI_CK_SLOT_INFO() {
        super(jnr.ffi.Runtime.getSystemRuntime());
    }


    public JFFI_CK_SLOT_INFO readFrom(CK_SLOT_INFO info) {
        slotDescription = info.slotDescription;
        manufacturerID = info.manufacturerID;
        flags = info.flags;
        hardwareVersion = new JFFI_CK_VERSION().readFrom(info.hardwareVersion);
        firmwareVersion = new JFFI_CK_VERSION().readFrom(info.firmwareVersion);
        return this;
    }

    public CK_SLOT_INFO writeTo(CK_SLOT_INFO info) {
        info.slotDescription = slotDescription;
        info.manufacturerID = manufacturerID;
        info.flags = flags;
        hardwareVersion.writeTo(info.hardwareVersion);
        firmwareVersion.writeTo(info.firmwareVersion);
        return info;
    }
}
