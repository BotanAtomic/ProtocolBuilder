package package com.ankamagames.dofus.network.messages.game.tinsel;

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
import java.lang.Exception;
import java.lang.Exception;

public class TitlesAndOrnamentsListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6367;
    private boolean _isInitialized = false;
    private Vector.<uint> titles = ;
    private Vector.<uint> ornaments = ;
    private int activeTitle = 0;
    private int activeOrnament = 0;
    private FuncTree _titlestree = ;
    private FuncTree _ornamentstree = ;
    private int _loc2_ = 0;
    private int _loc3_ = 0;
    private int _loc7_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc5_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6367;
    }

    public TitlesAndOrnamentsListMessage initTitlesAndOrnamentsListMessage(Vector.<uint> param1,Vector.<uint>  param2,int  param3,int  param4) {
         this.titles = param1;
         this.ornaments = param2;
         this.activeTitle = param3;
         this.activeOrnament = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.titles = new Vector.<uint>();
         this.ornaments = new Vector.<uint>();
         this.activeTitle = 0;
         this.activeOrnament = 0;
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
         this.serializeAs_TitlesAndOrnamentsListMessage(param1);
    }

    public void serializeAs_TitlesAndOrnamentsListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.titles.length);
         int _loc2_ = 0;
         while(_loc2_ < this.titles.length)
            if(this.titles[_loc2_] < 0)
               throw new Exception("Forbidden value (" + this.titles[_loc2_] + ") on element 1 (starting at 1) of titles.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TitlesAndOrnamentsListMessage(param1);
    }

    public void deserializeAs_TitlesAndOrnamentsListMessage(ICustomDataInput param1) {
         int _loc6_ = 0;
         int _loc7_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc6_ = param1.readVarUhShort();
            if(_loc6_ < 0)
               throw new Exception("Forbidden value (" + _loc6_ + ") on elements of titles.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TitlesAndOrnamentsListMessage(param1);
    }

    public void deserializeAsyncAs_TitlesAndOrnamentsListMessage(FuncTree param1) {
         this._titlestree = param1.addChild(this._titlestreeFunc);
         this._ornamentstree = param1.addChild(this._ornamentstreeFunc);
         param1.addChild(this._activeTitleFunc);
         param1.addChild(this._activeOrnamentFunc);
    }

    private void _titlestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._titlestree.addChild(this._titlesFunc);
            _loc3_++;
    }

    private void _titlesFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of titles.");
    }

    private void _ornamentstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._ornamentstree.addChild(this._ornamentsFunc);
            _loc3_++;
    }

    private void _ornamentsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of ornaments.");
    }

    private void _activeTitleFunc(ICustomDataInput param1) {
         this.activeTitle = param1.readVarUhShort();
         if(this.activeTitle < 0)
            throw new Exception("Forbidden value (" + this.activeTitle + ") on element of TitlesAndOrnamentsListMessage.activeTitle.");
    }

    private void _activeOrnamentFunc(ICustomDataInput param1) {
         this.activeOrnament = param1.readVarUhShort();
         if(this.activeOrnament < 0)
            throw new Exception("Forbidden value (" + this.activeOrnament + ") on element of TitlesAndOrnamentsListMessage.activeOrnament.");
    }

}