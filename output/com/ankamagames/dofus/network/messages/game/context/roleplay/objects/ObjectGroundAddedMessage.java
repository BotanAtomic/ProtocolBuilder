package com.ankamagames.dofus.network.messages.game.context.roleplay.objects;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ObjectGroundAddedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 3017;
    private boolean _isInitialized = false;
    private int cellId = 0;
    private int objectGID = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 3017;
    }

    public ObjectGroundAddedMessage initObjectGroundAddedMessage(int param1,int  param2) {
         this.cellId = param1;
         this.objectGID = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.cellId = 0;
         this.objectGID = 0;
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ObjectGroundAddedMessage(param1);
    }

    public void serializeAs_ObjectGroundAddedMessage(ICustomDataOutput param1) {
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
         this.deserializeAs_ObjectGroundAddedMessage(param1);
    }

    public void deserializeAs_ObjectGroundAddedMessage(ICustomDataInput param1) {
         this._cellIdFunc(param1);
         this._objectGIDFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectGroundAddedMessage(param1);
    }

    public void deserializeAsyncAs_ObjectGroundAddedMessage(FuncTree param1) {
         param1.addChild(this._cellIdFunc);
         param1.addChild(this._objectGIDFunc);
    }

    private void _cellIdFunc(ICustomDataInput param1) {
         this.cellId = param1.readVarUhShort();
         if(this.cellId < 0 || this.cellId > 559)
         {
            throw new Exception("Forbidden value (" + this.cellId + ") on element of ObjectGroundAddedMessage.cellId.");
         }
    }

    private void _objectGIDFunc(ICustomDataInput param1) {
         this.objectGID = param1.readVarUhShort();
         if(this.objectGID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectGID + ") on element of ObjectGroundAddedMessage.objectGID.");
         }
    }

}