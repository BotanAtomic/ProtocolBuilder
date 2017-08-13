package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ObjectItemInRolePlay extends Object implements INetworkType {

    private int protocolId = 198;
    private int cellId = 0;
    private int objectGID = 0;


    public int getTypeId() {
         return 198;
    }

    public ObjectItemInRolePlay initObjectItemInRolePlay(int param1,int  param2) {
         this.cellId = param1;
         this.objectGID = param2;
         return this;
    }

    public void reset() {
         this.cellId = 0;
         this.objectGID = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ObjectItemInRolePlay(param1);
    }

    public void serializeAs_ObjectItemInRolePlay(ICustomDataOutput param1) {
         if(this.cellId < 0 || this.cellId > 559)
         {
            throw new Exception("Forbidden value (" + this.cellId + ") on element cellId.");
         }
         param1.writeVarShort(this.cellId);
         if(this.objectGID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectGID + ") on element objectGID.");
         }
         param1.writeVarShort(this.objectGID);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectItemInRolePlay(param1);
    }

    public void deserializeAs_ObjectItemInRolePlay(ICustomDataInput param1) {
         this._cellIdFunc(param1);
         this._objectGIDFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectItemInRolePlay(param1);
    }

    public void deserializeAsyncAs_ObjectItemInRolePlay(FuncTree param1) {
         param1.addChild(this._cellIdFunc);
         param1.addChild(this._objectGIDFunc);
    }

    private void _cellIdFunc(ICustomDataInput param1) {
         this.cellId = param1.readVarUhShort();
         if(this.cellId < 0 || this.cellId > 559)
         {
            throw new Exception("Forbidden value (" + this.cellId + ") on element of ObjectItemInRolePlay.cellId.");
         }
    }

    private void _objectGIDFunc(ICustomDataInput param1) {
         this.objectGID = param1.readVarUhShort();
         if(this.objectGID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectGID + ") on element of ObjectItemInRolePlay.objectGID.");
         }
    }

}