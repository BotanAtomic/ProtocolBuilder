package com.ankamagames.dofus.network.types.game.context;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class EntityDispositionInformations extends Object implements INetworkType {

    private int protocolId = 60;
    private int cellId = 0;
    private int direction = 1;


    public int getTypeId() {
         return 60;
    }

    public EntityDispositionInformations initEntityDispositionInformations(int param1,int  param2) {
         this.cellId = param1;
         this.direction = param2;
         return this;
    }

    public void reset() {
         this.cellId = 0;
         this.direction = 1;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_EntityDispositionInformations(param1);
    }

    public void serializeAs_EntityDispositionInformations(ICustomDataOutput param1) {
         if(this.cellId < -1 || this.cellId > 559)
         {
            throw new Exception("Forbidden value (" + this.cellId + ") on element cellId.");
         }
         param1.writeShort(this.cellId);
         param1.writeByte(this.direction);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_EntityDispositionInformations(param1);
    }

    public void deserializeAs_EntityDispositionInformations(ICustomDataInput param1) {
         this._cellIdFunc(param1);
         this._directionFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_EntityDispositionInformations(param1);
    }

    public void deserializeAsyncAs_EntityDispositionInformations(FuncTree param1) {
         param1.addChild(this._cellIdFunc);
         param1.addChild(this._directionFunc);
    }

    private void _cellIdFunc(ICustomDataInput param1) {
         this.cellId = param1.readShort();
         if(this.cellId < -1 || this.cellId > 559)
         {
            throw new Exception("Forbidden value (" + this.cellId + ") on element of EntityDispositionInformations.cellId.");
         }
    }

    private void _directionFunc(ICustomDataInput param1) {
         this.direction = param1.readByte();
         if(this.direction < 0)
         {
            throw new Exception("Forbidden value (" + this.direction + ") on element of EntityDispositionInformations.direction.");
         }
    }

}