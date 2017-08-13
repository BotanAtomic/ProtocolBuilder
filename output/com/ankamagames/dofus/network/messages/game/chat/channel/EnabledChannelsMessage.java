package com.ankamagames.dofus.network.messages.game.chat.channel;

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

public class EnabledChannelsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 892;
    private boolean _isInitialized = false;
    private Vector<uint> channels;
    private Vector<uint> disallowed;
    private FuncTree _channelstree;
    private FuncTree _disallowedtree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 892;
    }

    public EnabledChannelsMessage initEnabledChannelsMessage(Vector<uint> param1,Vector<uint>  param2) {
         this.channels = param1;
         this.disallowed = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.channels = new Vector.<uint>();
         this.disallowed = new Vector.<uint>();
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
         this.serializeAs_EnabledChannelsMessage(param1);
    }

    public void serializeAs_EnabledChannelsMessage(ICustomDataOutput param1) {
         param1.writeShort(this.channels.length);
         int _loc2_ = 0;
         while(_loc2_ < this.channels.length)
         {
            param1.writeByte(this.channels[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.disallowed.length);
         int _loc3_ = 0;
         while(_loc3_ < this.disallowed.length)
         {
            param1.writeByte(this.disallowed[_loc3_]);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_EnabledChannelsMessage(param1);
    }

    public void deserializeAs_EnabledChannelsMessage(ICustomDataInput param1) {
         int _loc6_ = 0;
         int _loc7_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readByte();
            if(_loc6_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc6_ + ") on elements of channels.");
            }
            this.channels.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = param1.readByte();
            if(_loc7_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc7_ + ") on elements of disallowed.");
            }
            this.disallowed.push(_loc7_);
            _loc5_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_EnabledChannelsMessage(param1);
    }

    public void deserializeAsyncAs_EnabledChannelsMessage(FuncTree param1) {
         this._channelstree = param1.addChild(this._channelstreeFunc);
         this._disallowedtree = param1.addChild(this._disallowedtreeFunc);
    }

    private void _channelstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._channelstree.addChild(this._channelsFunc);
            _loc3_++;
         }
    }

    private void _channelsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         if(_loc2_ < 0)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of channels.");
         }
         this.channels.push(_loc2_);
    }

    private void _disallowedtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._disallowedtree.addChild(this._disallowedFunc);
            _loc3_++;
         }
    }

    private void _disallowedFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         if(_loc2_ < 0)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of disallowed.");
         }
         this.disallowed.push(_loc2_);
    }

}