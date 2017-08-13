package com.ankamagames.dofus.network.messages.game.friend;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.friend.FriendSpouseInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class SpouseInformationsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6356;
    private boolean _isInitialized = false;
    private FriendSpouseInformations spouse;
    private FuncTree _spousetree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6356;
    }

    public SpouseInformationsMessage initSpouseInformationsMessage(FriendSpouseInformations param1) {
         this.spouse = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.spouse = new FriendSpouseInformations();
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
         this.serializeAs_SpouseInformationsMessage(param1);
    }

    public void serializeAs_SpouseInformationsMessage(ICustomDataOutput param1) {
         param1.writeShort(this.spouse.getTypeId());
         this.spouse.serialize(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SpouseInformationsMessage(param1);
    }

    public void deserializeAs_SpouseInformationsMessage(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.spouse = ProtocolTypeManager.getInstance(FriendSpouseInformations,_loc2_);
         this.spouse.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_SpouseInformationsMessage(param1);
    }

    public void deserializeAsyncAs_SpouseInformationsMessage(FuncTree param1) {
         this._spousetree = param1.addChild(this._spousetreeFunc);
    }

    private void _spousetreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.spouse = ProtocolTypeManager.getInstance(FriendSpouseInformations,_loc2_);
         this.spouse.deserializeAsync(this._spousetree);
    }

}