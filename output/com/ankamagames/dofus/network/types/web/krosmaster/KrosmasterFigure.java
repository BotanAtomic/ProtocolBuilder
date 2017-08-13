package package com.ankamagames.dofus.network.types.web.krosmaster;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class KrosmasterFigure extends Object implements INetworkType {

    private int protocolId = 397;
    private String uid = "";
    private int figure = 0;
    private int pedestal = 0;
    private boolean bound = false;


    public int getTypeId() {
         return 397;
    }

    public KrosmasterFigure initKrosmasterFigure(String param1,int  param2,int  param3,boolean  param4) {
         this.uid = param1;
         this.figure = param2;
         this.pedestal = param3;
         this.bound = param4;
         return this;
    }

    public void reset() {
         this.uid = "";
         this.figure = 0;
         this.pedestal = 0;
         this.bound = false;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_KrosmasterFigure(param1);
    }

    public void serializeAs_KrosmasterFigure(ICustomDataOutput param1) {
         param1.writeUTF(this.uid);
         if(this.figure < 0)
            throw new Exception("Forbidden value (" + this.figure + ") on element figure.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_KrosmasterFigure(param1);
    }

    public void deserializeAs_KrosmasterFigure(ICustomDataInput param1) {
         this._uidFunc(param1);
         this._figureFunc(param1);
         this._pedestalFunc(param1);
         this._boundFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_KrosmasterFigure(param1);
    }

    public void deserializeAsyncAs_KrosmasterFigure(FuncTree param1) {
         param1.addChild(this._uidFunc);
         param1.addChild(this._figureFunc);
         param1.addChild(this._pedestalFunc);
         param1.addChild(this._boundFunc);
    }

    private void _uidFunc(ICustomDataInput param1) {
         this.uid = param1.readUTF();
    }

    private void _figureFunc(ICustomDataInput param1) {
         this.figure = param1.readVarUhShort();
         if(this.figure < 0)
            throw new Exception("Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    private void _pedestalFunc(ICustomDataInput param1) {
         this.pedestal = param1.readVarUhShort();
         if(this.pedestal < 0)
            throw new Exception("Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    private void _boundFunc(ICustomDataInput param1) {
         this.bound = param1.readBoolean();
    }

}