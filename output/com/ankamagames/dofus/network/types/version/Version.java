package com.ankamagames.dofus.network.types.version;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class Version extends Object implements INetworkType {

    private int protocolId = 11;
    private int major = 0;
    private int minor = 0;
    private int release = 0;
    private int revision = 0;
    private int patch = 0;
    private int buildType = 0;


    public int getTypeId() {
         return 11;
    }

    public Version initVersion(int param1,int  param2,int  param3,int  param4,int  param5,int  param6) {
         this.major = param1;
         this.minor = param2;
         this.release = param3;
         this.revision = param4;
         this.patch = param5;
         this.buildType = param6;
         return this;
    }

    public void reset() {
         this.major = 0;
         this.minor = 0;
         this.release = 0;
         this.revision = 0;
         this.patch = 0;
         this.buildType = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_Version(param1);
    }

    public void serializeAs_Version(ICustomDataOutput param1) {
         if(this.major < 0)
         {
            throw new Exception("Forbidden value (" + this.major + ") on element major.");
         }
         param1.writeByte(this.major);
         if(this.minor < 0)
         {
            throw new Exception("Forbidden value (" + this.minor + ") on element minor.");
         }
         param1.writeByte(this.minor);
         if(this.release < 0)
         {
            throw new Exception("Forbidden value (" + this.release + ") on element release.");
         }
         param1.writeByte(this.release);
         if(this.revision < 0)
         {
            throw new Exception("Forbidden value (" + this.revision + ") on element revision.");
         }
         param1.writeInt(this.revision);
         if(this.patch < 0)
         {
            throw new Exception("Forbidden value (" + this.patch + ") on element patch.");
         }
         param1.writeByte(this.patch);
         param1.writeByte(this.buildType);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_Version(param1);
    }

    public void deserializeAs_Version(ICustomDataInput param1) {
         this._majorFunc(param1);
         this._minorFunc(param1);
         this._releaseFunc(param1);
         this._revisionFunc(param1);
         this._patchFunc(param1);
         this._buildTypeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_Version(param1);
    }

    public void deserializeAsyncAs_Version(FuncTree param1) {
         param1.addChild(this._majorFunc);
         param1.addChild(this._minorFunc);
         param1.addChild(this._releaseFunc);
         param1.addChild(this._revisionFunc);
         param1.addChild(this._patchFunc);
         param1.addChild(this._buildTypeFunc);
    }

    private void _majorFunc(ICustomDataInput param1) {
         this.major = param1.readByte();
         if(this.major < 0)
         {
            throw new Exception("Forbidden value (" + this.major + ") on element of Version.major.");
         }
    }

    private void _minorFunc(ICustomDataInput param1) {
         this.minor = param1.readByte();
         if(this.minor < 0)
         {
            throw new Exception("Forbidden value (" + this.minor + ") on element of Version.minor.");
         }
    }

    private void _releaseFunc(ICustomDataInput param1) {
         this.release = param1.readByte();
         if(this.release < 0)
         {
            throw new Exception("Forbidden value (" + this.release + ") on element of Version.release.");
         }
    }

    private void _revisionFunc(ICustomDataInput param1) {
         this.revision = param1.readInt();
         if(this.revision < 0)
         {
            throw new Exception("Forbidden value (" + this.revision + ") on element of Version.revision.");
         }
    }

    private void _patchFunc(ICustomDataInput param1) {
         this.patch = param1.readByte();
         if(this.patch < 0)
         {
            throw new Exception("Forbidden value (" + this.patch + ") on element of Version.patch.");
         }
    }

    private void _buildTypeFunc(ICustomDataInput param1) {
         this.buildType = param1.readByte();
         if(this.buildType < 0)
         {
            throw new Exception("Forbidden value (" + this.buildType + ") on element of Version.buildType.");
         }
    }

}