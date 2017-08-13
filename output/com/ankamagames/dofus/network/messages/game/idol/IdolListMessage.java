package com.ankamagames.dofus.network.messages.game.idol;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.idol.PartyIdol;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class IdolListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6585;
    private boolean _isInitialized = false;
    private Vector<uint> chosenIdols;
    private Vector<uint> partyChosenIdols;
    private Vector<PartyIdol> partyIdols;
    private FuncTree _chosenIdolstree;
    private FuncTree _partyChosenIdolstree;
    private FuncTree _partyIdolstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6585;
    }

    public IdolListMessage initIdolListMessage(Vector<uint> param1,Vector<uint>  param2,Vector<PartyIdol>  param3) {
         this.chosenIdols = param1;
         this.partyChosenIdols = param2;
         this.partyIdols = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.chosenIdols = new Vector.<uint>();
         this.partyChosenIdols = new Vector.<uint>();
         this.partyIdols = new Vector.<PartyIdol>();
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
         this.serializeAs_IdolListMessage(param1);
    }

    public void serializeAs_IdolListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.chosenIdols.length);
         int _loc2_ = 0;
         while(_loc2_ < this.chosenIdols.length)
         {
            if(this.chosenIdols[_loc2_] < 0)
            {
               throw new Exception("Forbidden value (" + this.chosenIdols[_loc2_] + ") on element 1 (starting at 1) of chosenIdols.");
            }
            param1.writeVarShort(this.chosenIdols[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.partyChosenIdols.length);
         int _loc3_ = 0;
         while(_loc3_ < this.partyChosenIdols.length)
         {
            if(this.partyChosenIdols[_loc3_] < 0)
            {
               throw new Exception("Forbidden value (" + this.partyChosenIdols[_loc3_] + ") on element 2 (starting at 1) of partyChosenIdols.");
            }
            param1.writeVarShort(this.partyChosenIdols[_loc3_]);
            _loc3_++;
         }
         param1.writeShort(this.partyIdols.length);
         int _loc4_ = 0;
         while(_loc4_ < this.partyIdols.length)
         {
            param1.writeShort((this.partyIdols[_loc4_] as PartyIdol).getTypeId());
            (this.partyIdols[_loc4_] as PartyIdol).serialize(param1);
            _loc4_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IdolListMessage(param1);
    }

    public void deserializeAs_IdolListMessage(ICustomDataInput param1) {
         int _loc8_ = 0;
         int _loc9_ = 0;
         int _loc10_ = 0;
         PartyIdol _loc11_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc8_ = param1.readVarUhShort();
            if(_loc8_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc8_ + ") on elements of chosenIdols.");
            }
            this.chosenIdols.push(_loc8_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc9_ = param1.readVarUhShort();
            if(_loc9_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc9_ + ") on elements of partyChosenIdols.");
            }
            this.partyChosenIdols.push(_loc9_);
            _loc5_++;
         }
         int _loc6_ = param1.readUnsignedShort();
         int _loc7_ = 0;
         while(_loc7_ < _loc6_)
         {
            _loc10_ = param1.readUnsignedShort();
            _loc11_ = ProtocolTypeManager.getInstance(PartyIdol,_loc10_);
            _loc11_.deserialize(param1);
            this.partyIdols.push(_loc11_);
            _loc7_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_IdolListMessage(param1);
    }

    public void deserializeAsyncAs_IdolListMessage(FuncTree param1) {
         this._chosenIdolstree = param1.addChild(this._chosenIdolstreeFunc);
         this._partyChosenIdolstree = param1.addChild(this._partyChosenIdolstreeFunc);
         this._partyIdolstree = param1.addChild(this._partyIdolstreeFunc);
    }

    private void _chosenIdolstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._chosenIdolstree.addChild(this._chosenIdolsFunc);
            _loc3_++;
         }
    }

    private void _chosenIdolsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of chosenIdols.");
         }
         this.chosenIdols.push(_loc2_);
    }

    private void _partyChosenIdolstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._partyChosenIdolstree.addChild(this._partyChosenIdolsFunc);
            _loc3_++;
         }
    }

    private void _partyChosenIdolsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of partyChosenIdols.");
         }
         this.partyChosenIdols.push(_loc2_);
    }

    private void _partyIdolstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._partyIdolstree.addChild(this._partyIdolsFunc);
            _loc3_++;
         }
    }

    private void _partyIdolsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         PartyIdol _loc3_ = ProtocolTypeManager.getInstance(PartyIdol,_loc2_);
         _loc3_.deserialize(param1);
         this.partyIdols.push(_loc3_);
    }

}