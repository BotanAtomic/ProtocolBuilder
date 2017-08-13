package com.ankamagames.dofus.network.messages.game.context.roleplay.npc;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class NpcGenericActionRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5898;
    private boolean _isInitialized = false;
    private int npcId = 0;
    private int npcActionId = 0;
    private int npcMapId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5898;
    }

    public NpcGenericActionRequestMessage initNpcGenericActionRequestMessage(int param1,int  param2,int  param3) {
         this.npcId = param1;
         this.npcActionId = param2;
         this.npcMapId = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.npcId = 0;
         this.npcActionId = 0;
         this.npcMapId = 0;
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         if(HASH_FUNCTION != null)
         {
            HASH_FUNCTION(_loc2_);
         }
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
         this.serializeAs_NpcGenericActionRequestMessage(param1);
    }

    public void serializeAs_NpcGenericActionRequestMessage(ICustomDataOutput param1) {
         param1.writeInt(this.npcId);
         if(this.npcActionId < 0)
         {
            throw new Exception("Forbidden value (" + this.npcActionId + ") on element npcActionId.");
         }
         param1.writeByte(this.npcActionId);
         param1.writeInt(this.npcMapId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_NpcGenericActionRequestMessage(param1);
    }

    public void deserializeAs_NpcGenericActionRequestMessage(ICustomDataInput param1) {
         this._npcIdFunc(param1);
         this._npcActionIdFunc(param1);
         this._npcMapIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_NpcGenericActionRequestMessage(param1);
    }

    public void deserializeAsyncAs_NpcGenericActionRequestMessage(FuncTree param1) {
         param1.addChild(this._npcIdFunc);
         param1.addChild(this._npcActionIdFunc);
         param1.addChild(this._npcMapIdFunc);
    }

    private void _npcIdFunc(ICustomDataInput param1) {
         this.npcId = param1.readInt();
    }

    private void _npcActionIdFunc(ICustomDataInput param1) {
         this.npcActionId = param1.readByte();
         if(this.npcActionId < 0)
         {
            throw new Exception("Forbidden value (" + this.npcActionId + ") on element of NpcGenericActionRequestMessage.npcActionId.");
         }
    }

    private void _npcMapIdFunc(ICustomDataInput param1) {
         this.npcMapId = param1.readInt();
    }

}