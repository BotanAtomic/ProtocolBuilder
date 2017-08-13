package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.action.fight.FightDispellableEffectExtendedInformations;
import com.ankamagames.dofus.network.types.game.actions.fight.GameActionMark;
import com.ankamagames.dofus.network.types.game.idol.Idol;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameFightSpectateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6069;
    private boolean _isInitialized = false;
    private Vector<FightDispellableEffectExtendedInformations> effects;
    private Vector<GameActionMark> marks;
    private int gameTurn = 0;
    private int fightStart = 0;
    private Vector<Idol> idols;
    private FuncTree _effectstree;
    private FuncTree _markstree;
    private FuncTree _idolstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6069;
    }

    public GameFightSpectateMessage initGameFightSpectateMessage(Vector<FightDispellableEffectExtendedInformations> param1,Vector<GameActionMark>  param2,int  param3,int  param4,Vector<Idol>  param5) {
         this.effects = param1;
         this.marks = param2;
         this.gameTurn = param3;
         this.fightStart = param4;
         this.idols = param5;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.effects = new Vector.<FightDispellableEffectExtendedInformations>();
         this.marks = new Vector.<GameActionMark>();
         this.gameTurn = 0;
         this.fightStart = 0;
         this.idols = new Vector.<Idol>();
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
         this.serializeAs_GameFightSpectateMessage(param1);
    }

    public void serializeAs_GameFightSpectateMessage(ICustomDataOutput param1) {
         param1.writeShort(this.effects.length);
         int _loc2_ = 0;
         while(_loc2_ < this.effects.length)
         {
            (this.effects[_loc2_] as FightDispellableEffectExtendedInformations).serializeAs_FightDispellableEffectExtendedInformations(param1);
            _loc2_++;
         }
         param1.writeShort(this.marks.length);
         int _loc3_ = 0;
         while(_loc3_ < this.marks.length)
         {
            (this.marks[_loc3_] as GameActionMark).serializeAs_GameActionMark(param1);
            _loc3_++;
         }
         if(this.gameTurn < 0)
         {
            throw new Exception("Forbidden value (" + this.gameTurn + ") on element gameTurn.");
         }
         param1.writeVarShort(this.gameTurn);
         if(this.fightStart < 0)
         {
            throw new Exception("Forbidden value (" + this.fightStart + ") on element fightStart.");
         }
         param1.writeInt(this.fightStart);
         param1.writeShort(this.idols.length);
         int _loc4_ = 0;
         while(_loc4_ < this.idols.length)
         {
            (this.idols[_loc4_] as Idol).serializeAs_Idol(param1);
            _loc4_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightSpectateMessage(param1);
    }

    public void deserializeAs_GameFightSpectateMessage(ICustomDataInput param1) {
         FightDispellableEffectExtendedInformations _loc8_ = null;
         GameActionMark _loc9_ = null;
         Idol _loc10_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc8_ = new FightDispellableEffectExtendedInformations();
            _loc8_.deserialize(param1);
            this.effects.push(_loc8_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc9_ = new GameActionMark();
            _loc9_.deserialize(param1);
            this.marks.push(_loc9_);
            _loc5_++;
         }
         this._gameTurnFunc(param1);
         this._fightStartFunc(param1);
         int _loc6_ = param1.readUnsignedShort();
         int _loc7_ = 0;
         while(_loc7_ < _loc6_)
         {
            _loc10_ = new Idol();
            _loc10_.deserialize(param1);
            this.idols.push(_loc10_);
            _loc7_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightSpectateMessage(param1);
    }

    public void deserializeAsyncAs_GameFightSpectateMessage(FuncTree param1) {
         this._effectstree = param1.addChild(this._effectstreeFunc);
         this._markstree = param1.addChild(this._markstreeFunc);
         param1.addChild(this._gameTurnFunc);
         param1.addChild(this._fightStartFunc);
         this._idolstree = param1.addChild(this._idolstreeFunc);
    }

    private void _effectstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._effectstree.addChild(this._effectsFunc);
            _loc3_++;
         }
    }

    private void _effectsFunc(ICustomDataInput param1) {
         FightDispellableEffectExtendedInformations _loc2_ = new FightDispellableEffectExtendedInformations();
         _loc2_.deserialize(param1);
         this.effects.push(_loc2_);
    }

    private void _markstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._markstree.addChild(this._marksFunc);
            _loc3_++;
         }
    }

    private void _marksFunc(ICustomDataInput param1) {
         GameActionMark _loc2_ = new GameActionMark();
         _loc2_.deserialize(param1);
         this.marks.push(_loc2_);
    }

    private void _gameTurnFunc(ICustomDataInput param1) {
         this.gameTurn = param1.readVarUhShort();
         if(this.gameTurn < 0)
         {
            throw new Exception("Forbidden value (" + this.gameTurn + ") on element of GameFightSpectateMessage.gameTurn.");
         }
    }

    private void _fightStartFunc(ICustomDataInput param1) {
         this.fightStart = param1.readInt();
         if(this.fightStart < 0)
         {
            throw new Exception("Forbidden value (" + this.fightStart + ") on element of GameFightSpectateMessage.fightStart.");
         }
    }

    private void _idolstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._idolstree.addChild(this._idolsFunc);
            _loc3_++;
         }
    }

    private void _idolsFunc(ICustomDataInput param1) {
         Idol _loc2_ = new Idol();
         _loc2_.deserialize(param1);
         this.idols.push(_loc2_);
    }

}