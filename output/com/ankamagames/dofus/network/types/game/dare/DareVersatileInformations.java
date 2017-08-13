package com.ankamagames.dofus.network.types.game.dare;

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

public class DareVersatileInformations extends Object implements INetworkType {

    private int protocolId = 504;
    private Number dareId = 0;
    private int countEntrants = 0;
    private int countWinners = 0;


    public int getTypeId() {
         return 504;
    }

    public DareVersatileInformations initDareVersatileInformations(Number param1,int  param2,int  param3) {
         this.dareId = param1;
         this.countEntrants = param2;
         this.countWinners = param3;
         return this;
    }

    public void reset() {
         this.dareId = 0;
         this.countEntrants = 0;
         this.countWinners = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_DareVersatileInformations(param1);
    }

    public void serializeAs_DareVersatileInformations(ICustomDataOutput param1) {
         if(this.dareId < 0 || this.dareId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.dareId + ") on element dareId.");
         }
         param1.writeDouble(this.dareId);
         if(this.countEntrants < 0)
         {
            throw new Exception("Forbidden value (" + this.countEntrants + ") on element countEntrants.");
         }
         param1.writeInt(this.countEntrants);
         if(this.countWinners < 0)
         {
            throw new Exception("Forbidden value (" + this.countWinners + ") on element countWinners.");
         }
         param1.writeInt(this.countWinners);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DareVersatileInformations(param1);
    }

    public void deserializeAs_DareVersatileInformations(ICustomDataInput param1) {
         this._dareIdFunc(param1);
         this._countEntrantsFunc(param1);
         this._countWinnersFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DareVersatileInformations(param1);
    }

    public void deserializeAsyncAs_DareVersatileInformations(FuncTree param1) {
         param1.addChild(this._dareIdFunc);
         param1.addChild(this._countEntrantsFunc);
         param1.addChild(this._countWinnersFunc);
    }

    private void _dareIdFunc(ICustomDataInput param1) {
         this.dareId = param1.readDouble();
         if(this.dareId < 0 || this.dareId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.dareId + ") on element of DareVersatileInformations.dareId.");
         }
    }

    private void _countEntrantsFunc(ICustomDataInput param1) {
         this.countEntrants = param1.readInt();
         if(this.countEntrants < 0)
         {
            throw new Exception("Forbidden value (" + this.countEntrants + ") on element of DareVersatileInformations.countEntrants.");
         }
    }

    private void _countWinnersFunc(ICustomDataInput param1) {
         this.countWinners = param1.readInt();
         if(this.countWinners < 0)
         {
            throw new Exception("Forbidden value (" + this.countWinners + ") on element of DareVersatileInformations.countWinners.");
         }
    }

}