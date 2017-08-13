package com.ankamagames.dofus.network.messages.game.context.roleplay.emote;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class EmoteListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5689;
    private boolean _isInitialized = false;
    private Vector<uint> emoteIds;
    private FuncTree _emoteIdstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5689;
    }

    public EmoteListMessage initEmoteListMessage(Vector<uint> param1) {
         this.emoteIds = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.emoteIds = new Vector.<uint>();
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
         this.serializeAs_EmoteListMessage(param1);
    }

    public void serializeAs_EmoteListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.emoteIds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.emoteIds.length)
         {
            if(this.emoteIds[_loc2_] < 0 || this.emoteIds[_loc2_] > 255)
            {
               throw new Exception("Forbidden value (" + this.emoteIds[_loc2_] + ") on element 1 (starting at 1) of emoteIds.");
            }
            param1.writeByte(this.emoteIds[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_EmoteListMessage(param1);
    }

    public void deserializeAs_EmoteListMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedByte();
            if(_loc4_ < 0 || _loc4_ > 255)
            {
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of emoteIds.");
            }
            this.emoteIds.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_EmoteListMessage(param1);
    }

    public void deserializeAsyncAs_EmoteListMessage(FuncTree param1) {
         this._emoteIdstree = param1.addChild(this._emoteIdstreeFunc);
    }

    private void _emoteIdstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._emoteIdstree.addChild(this._emoteIdsFunc);
            _loc3_++;
         }
    }

    private void _emoteIdsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedByte();
         if(_loc2_ < 0 || _loc2_ > 255)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of emoteIds.");
         }
         this.emoteIds.push(_loc2_);
    }

}