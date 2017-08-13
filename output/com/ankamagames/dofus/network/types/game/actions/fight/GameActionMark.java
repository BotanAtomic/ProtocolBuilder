package com.ankamagames.dofus.network.types.game.actions.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameActionMark extends Object implements INetworkType {

    private int protocolId = 351;
    private Number markAuthorId = 0;
    private int markTeamId = 2;
    private int markSpellId = 0;
    private int markSpellLevel = 0;
    private int markId = 0;
    private int markType = 0;
    private int markimpactCell = 0;
    private Vector<GameActionMarkedCell> cells;
    private boolean active = false;
    private FuncTree _cellstree;


    public int getTypeId() {
         return 351;
    }

    public GameActionMark initGameActionMark(Number param1,int  param2,int  param3,int  param4,int  param5,int  param6,int  param7,Vector<GameActionMarkedCell>  param8,boolean  param9) {
         this.markAuthorId = param1;
         this.markTeamId = param2;
         this.markSpellId = param3;
         this.markSpellLevel = param4;
         this.markId = param5;
         this.markType = param6;
         this.markimpactCell = param7;
         this.cells = param8;
         this.active = param9;
         return this;
    }

    public void reset() {
         this.markAuthorId = 0;
         this.markTeamId = 2;
         this.markSpellId = 0;
         this.markSpellLevel = 0;
         this.markId = 0;
         this.markType = 0;
         this.markimpactCell = 0;
         this.cells = new Vector.<GameActionMarkedCell>();
         this.active = false;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameActionMark(param1);
    }

    public void serializeAs_GameActionMark(ICustomDataOutput param1) {
         if(this.markAuthorId < -9.007199254740992E15 || this.markAuthorId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.markAuthorId + ") on element markAuthorId.");
         }
         param1.writeDouble(this.markAuthorId);
         param1.writeByte(this.markTeamId);
         if(this.markSpellId < 0)
         {
            throw new Exception("Forbidden value (" + this.markSpellId + ") on element markSpellId.");
         }
         param1.writeInt(this.markSpellId);
         if(this.markSpellLevel < 1 || this.markSpellLevel > 200)
         {
            throw new Exception("Forbidden value (" + this.markSpellLevel + ") on element markSpellLevel.");
         }
         param1.writeShort(this.markSpellLevel);
         param1.writeShort(this.markId);
         param1.writeByte(this.markType);
         if(this.markimpactCell < -1 || this.markimpactCell > 559)
         {
            throw new Exception("Forbidden value (" + this.markimpactCell + ") on element markimpactCell.");
         }
         param1.writeShort(this.markimpactCell);
         param1.writeShort(this.cells.length);
         int _loc2_ = 0;
         while(_loc2_ < this.cells.length)
         {
            (this.cells[_loc2_] as GameActionMarkedCell).serializeAs_GameActionMarkedCell(param1);
            _loc2_++;
         }
         param1.writeBoolean(this.active);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameActionMark(param1);
    }

    public void deserializeAs_GameActionMark(ICustomDataInput param1) {
         GameActionMarkedCell _loc4_ = null;
         this._markAuthorIdFunc(param1);
         this._markTeamIdFunc(param1);
         this._markSpellIdFunc(param1);
         this._markSpellLevelFunc(param1);
         this._markIdFunc(param1);
         this._markTypeFunc(param1);
         this._markimpactCellFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new GameActionMarkedCell();
            _loc4_.deserialize(param1);
            this.cells.push(_loc4_);
            _loc3_++;
         }
         this._activeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameActionMark(param1);
    }

    public void deserializeAsyncAs_GameActionMark(FuncTree param1) {
         param1.addChild(this._markAuthorIdFunc);
         param1.addChild(this._markTeamIdFunc);
         param1.addChild(this._markSpellIdFunc);
         param1.addChild(this._markSpellLevelFunc);
         param1.addChild(this._markIdFunc);
         param1.addChild(this._markTypeFunc);
         param1.addChild(this._markimpactCellFunc);
         this._cellstree = param1.addChild(this._cellstreeFunc);
         param1.addChild(this._activeFunc);
    }

    private void _markAuthorIdFunc(ICustomDataInput param1) {
         this.markAuthorId = param1.readDouble();
         if(this.markAuthorId < -9.007199254740992E15 || this.markAuthorId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.markAuthorId + ") on element of GameActionMark.markAuthorId.");
         }
    }

    private void _markTeamIdFunc(ICustomDataInput param1) {
         this.markTeamId = param1.readByte();
         if(this.markTeamId < 0)
         {
            throw new Exception("Forbidden value (" + this.markTeamId + ") on element of GameActionMark.markTeamId.");
         }
    }

    private void _markSpellIdFunc(ICustomDataInput param1) {
         this.markSpellId = param1.readInt();
         if(this.markSpellId < 0)
         {
            throw new Exception("Forbidden value (" + this.markSpellId + ") on element of GameActionMark.markSpellId.");
         }
    }

    private void _markSpellLevelFunc(ICustomDataInput param1) {
         this.markSpellLevel = param1.readShort();
         if(this.markSpellLevel < 1 || this.markSpellLevel > 200)
         {
            throw new Exception("Forbidden value (" + this.markSpellLevel + ") on element of GameActionMark.markSpellLevel.");
         }
    }

    private void _markIdFunc(ICustomDataInput param1) {
         this.markId = param1.readShort();
    }

    private void _markTypeFunc(ICustomDataInput param1) {
         this.markType = param1.readByte();
    }

    private void _markimpactCellFunc(ICustomDataInput param1) {
         this.markimpactCell = param1.readShort();
         if(this.markimpactCell < -1 || this.markimpactCell > 559)
         {
            throw new Exception("Forbidden value (" + this.markimpactCell + ") on element of GameActionMark.markimpactCell.");
         }
    }

    private void _cellstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._cellstree.addChild(this._cellsFunc);
            _loc3_++;
         }
    }

    private void _cellsFunc(ICustomDataInput param1) {
         GameActionMarkedCell _loc2_ = new GameActionMarkedCell();
         _loc2_.deserialize(param1);
         this.cells.push(_loc2_);
    }

    private void _activeFunc(ICustomDataInput param1) {
         this.active = param1.readBoolean();
    }

}