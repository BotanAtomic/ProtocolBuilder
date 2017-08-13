package package com.ankamagames.dofus.network.types.game.idol;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class Idol extends Object implements INetworkType {

    private int protocolId = 489;
    private int id = 0;
    private int xpBonusPercent = 0;
    private int dropBonusPercent = 0;


    public int getTypeId() {
         return 489;
    }

    public Idol initIdol(int param1,int  param2,int  param3) {
         this.id = param1;
         this.xpBonusPercent = param2;
         this.dropBonusPercent = param3;
         return this;
    }

    public void reset() {
         this.id = 0;
         this.xpBonusPercent = 0;
         this.dropBonusPercent = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_Idol(param1);
    }

    public void serializeAs_Idol(ICustomDataOutput param1) {
         if(this.id < 0)
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_Idol(param1);
    }

    public void deserializeAs_Idol(ICustomDataInput param1) {
         this._idFunc(param1);
         this._xpBonusPercentFunc(param1);
         this._dropBonusPercentFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_Idol(param1);
    }

    public void deserializeAsyncAs_Idol(FuncTree param1) {
         param1.addChild(this._idFunc);
         param1.addChild(this._xpBonusPercentFunc);
         param1.addChild(this._dropBonusPercentFunc);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readVarUhShort();
         if(this.id < 0)
            throw new Exception("Forbidden value (" + this.id + ") on element of Idol.id.");
    }

    private void _xpBonusPercentFunc(ICustomDataInput param1) {
         this.xpBonusPercent = param1.readVarUhShort();
         if(this.xpBonusPercent < 0)
            throw new Exception("Forbidden value (" + this.xpBonusPercent + ") on element of Idol.xpBonusPercent.");
    }

    private void _dropBonusPercentFunc(ICustomDataInput param1) {
         this.dropBonusPercent = param1.readVarUhShort();
         if(this.dropBonusPercent < 0)
            throw new Exception("Forbidden value (" + this.dropBonusPercent + ") on element of Idol.dropBonusPercent.");
    }

}