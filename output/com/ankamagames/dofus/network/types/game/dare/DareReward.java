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
import java.lang.Exception;

public class DareReward extends Object implements INetworkType {

    private int protocolId = 505;
    private int type = 0;
    private int monsterId = 0;
    private Number kamas = 0;
    private Number dareId = 0;


    public int getTypeId() {
         return 505;
    }

    public DareReward initDareReward(int param1,int  param2,Number  param3,Number  param4) {
         this.type = param1;
         this.monsterId = param2;
         this.kamas = param3;
         this.dareId = param4;
         return this;
    }

    public void reset() {
         this.type = 0;
         this.monsterId = 0;
         this.kamas = 0;
         this.dareId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_DareReward(param1);
    }

    public void serializeAs_DareReward(ICustomDataOutput param1) {
         param1.writeByte(this.type);
         if(this.monsterId < 0)
         {
            throw new Exception("Forbidden value (" + this.monsterId + ") on element monsterId.");
         }
         param1.writeVarShort(this.monsterId);
         if(this.kamas < 0 || this.kamas > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.kamas + ") on element kamas.");
         }
         param1.writeVarLong(this.kamas);
         if(this.dareId < 0 || this.dareId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.dareId + ") on element dareId.");
         }
         param1.writeDouble(this.dareId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DareReward(param1);
    }

    public void deserializeAs_DareReward(ICustomDataInput param1) {
         this._typeFunc(param1);
         this._monsterIdFunc(param1);
         this._kamasFunc(param1);
         this._dareIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DareReward(param1);
    }

    public void deserializeAsyncAs_DareReward(FuncTree param1) {
         param1.addChild(this._typeFunc);
         param1.addChild(this._monsterIdFunc);
         param1.addChild(this._kamasFunc);
         param1.addChild(this._dareIdFunc);
    }

    private void _typeFunc(ICustomDataInput param1) {
         this.type = param1.readByte();
         if(this.type < 0)
         {
            throw new Exception("Forbidden value (" + this.type + ") on element of DareReward.type.");
         }
    }

    private void _monsterIdFunc(ICustomDataInput param1) {
         this.monsterId = param1.readVarUhShort();
         if(this.monsterId < 0)
         {
            throw new Exception("Forbidden value (" + this.monsterId + ") on element of DareReward.monsterId.");
         }
    }

    private void _kamasFunc(ICustomDataInput param1) {
         this.kamas = param1.readVarUhLong();
         if(this.kamas < 0 || this.kamas > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.kamas + ") on element of DareReward.kamas.");
         }
    }

    private void _dareIdFunc(ICustomDataInput param1) {
         this.dareId = param1.readDouble();
         if(this.dareId < 0 || this.dareId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.dareId + ") on element of DareReward.dareId.");
         }
    }

}