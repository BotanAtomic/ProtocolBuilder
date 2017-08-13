package package com.ankamagames.dofus.network.messages.game.friend;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.friend.IgnoredInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class IgnoredListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5674;
    private boolean _isInitialized = false;
    private Vector.<IgnoredInformations> ignoredList = ;
    private FuncTree _ignoredListtree = ;
    private int _loc2_ = 0;
    private IgnoredInformations _loc5_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;
    private IgnoredInformations _loc3_ = ProtocolTypeManager.getInstance(IgnoredInformations,_loc2_);


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5674;
    }

    public IgnoredListMessage initIgnoredListMessage(Vector.<IgnoredInformations> param1) {
         this.ignoredList = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.ignoredList = new Vector.<IgnoredInformations>();
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
         this.serializeAs_IgnoredListMessage(param1);
    }

    public void serializeAs_IgnoredListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.ignoredList.length);
         int _loc2_ = 0;
         while(_loc2_ < this.ignoredList.length)
            param1.writeShort((this.ignoredList[_loc2_] as IgnoredInformations).getTypeId());
            (this.ignoredList[_loc2_] as IgnoredInformations).serialize(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IgnoredListMessage(param1);
    }

    public void deserializeAs_IgnoredListMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         IgnoredInformations _loc5_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(IgnoredInformations,_loc4_);
            _loc5_.deserialize(param1);
            this.ignoredList.push(_loc5_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_IgnoredListMessage(param1);
    }

    public void deserializeAsyncAs_IgnoredListMessage(FuncTree param1) {
         this._ignoredListtree = param1.addChild(this._ignoredListtreeFunc);
    }

    private void _ignoredListtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._ignoredListtree.addChild(this._ignoredListFunc);
            _loc3_++;
    }

    private void _ignoredListFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         IgnoredInformations _loc3_ = ProtocolTypeManager.getInstance(IgnoredInformations,_loc2_);
         _loc3_.deserialize(param1);
         this.ignoredList.push(_loc3_);
    }

}