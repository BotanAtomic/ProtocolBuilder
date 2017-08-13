package com.ankamagames.dofus.network.messages.game.context.roleplay.npc;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class NpcDialogCreationMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5618;
    private boolean _isInitialized = false;
    private int mapId = 0;
    private int npcId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5618;
    }

    public NpcDialogCreationMessage initNpcDialogCreationMessage(int param1,int  param2) {
         this.mapId = param1;
         this.npcId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.mapId = 0;
         this.npcId = 0;
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
         this.serializeAs_NpcDialogCreationMessage(param1);
    }

    public void serializeAs_NpcDialogCreationMessage(ICustomDataOutput param1) {
         param1.writeInt(this.mapId);
         param1.writeInt(this.npcId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_NpcDialogCreationMessage(param1);
    }

    public void deserializeAs_NpcDialogCreationMessage(ICustomDataInput param1) {
         this._mapIdFunc(param1);
         this._npcIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_NpcDialogCreationMessage(param1);
    }

    public void deserializeAsyncAs_NpcDialogCreationMessage(FuncTree param1) {
         param1.addChild(this._mapIdFunc);
         param1.addChild(this._npcIdFunc);
    }

    private void _mapIdFunc(ICustomDataInput param1) {
         this.mapId = param1.readInt();
    }

    private void _npcIdFunc(ICustomDataInput param1) {
         this.npcId = param1.readInt();
    }

}